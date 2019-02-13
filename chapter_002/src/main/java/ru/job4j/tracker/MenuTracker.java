package ru.job4j.tracker;

import java.util.*;
import java.util.function.Consumer;

public class MenuTracker {
    /**
     * Хранит ссылку на объект .
     */
    private Input input;
    /**
     * Хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * Хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

	/**
	 *
	 */
	private final Consumer<String> output;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
		this.output = output;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddAction(0, "Create new item"));
        this.actions.add(new ReplaceAction(1, "Edit item"));
        this.actions.add(new DeleteAction(2, "Delete item"));
        this.actions.add(new ShowAllAction(3, "Show all items"));
        this.actions.add(new FindByIdAction(4, "Find item by Id"));
        this.actions.add(new FindByNameAction(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }
	
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
		output.accept(System.lineSeparator() + "--------- Menu ---------");
        for (UserAction action : this.actions) {
            if (action != null) {
				output.accept(action.info());
            }
        }
		output.accept("------------------------");
    }


	/**
	 * Внутренний класс, добавление заявки.
	 */
	public class AddAction extends BaseAction {
		public AddAction(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			output.accept(System.lineSeparator() + "------------ Добавление новой заявки --------------");
			String name = input.ask("Введите имя заявки:");
			String desc = input.ask("Введите описание заявки:");
			Item item = new Item(name, desc);
			tracker.add(item);
			output.accept("Создана новая заявка с id: " + item.getId());
			output.accept("---------------------------------------------------");
		}  
	}
	
	/**
	 * Внутренний класс, изменение заявки.
	 */
	public class ReplaceAction extends BaseAction {
		public ReplaceAction(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			output.accept(System.lineSeparator() + "------------ Редактирование заявки --------------");
			String id = input.ask("Введите id заявки:");
			String name = input.ask("Введите новое имя заявки:");
			String desc = input.ask("Введите новое описание заявки:");
			Item item = new Item(name, desc);
			if (tracker.replace(id, item)) {
				output.accept("Заявка с id: " + id + " успешно отредактирована");
			} else {
				output.accept("Заявка с id: " + id + " не найдена");
			}
			output.accept("-------------------------------------------------");
		}
	}
	
	/**
	 * Внутренний класс, удаление заявки.
	 */
	public class DeleteAction extends BaseAction {
		public DeleteAction(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			output.accept(System.lineSeparator() + "------------ Удаление заявки --------------");
			String id = input.ask("Введите id заявки:");
			if (tracker.delete(id)) {
				output.accept("Заявка с Id: " + id + " успешно удалена");
			} else {
				output.accept("Заявка с id: " + id + " не найдена");
			}
			output.accept("-------------------------------------------");
		}
	}
	
	/**
	 * Внутренний класс, отображение всех заявок.
	 */
	public class ShowAllAction extends BaseAction {
		public ShowAllAction(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			output.accept(System.lineSeparator() + "------------ Отображение всех заявок --------------");
			for (Item i: tracker.findAll()) {
				output.accept(String.format("%s\t%s\t%s\t%tD %tT", i.getId(), i.getName(), i.getDesc(), i.getCreated(), i.getCreated()));
			}
			output.accept("---------------------------------------------------");
		}
	}
	
	/**
	 * Внутренний класс, поиск заявки по id.
	 */
	public class FindByIdAction extends BaseAction {
		public FindByIdAction(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			output.accept(System.lineSeparator() + "------------ Поиск заявки по ID --------------");
			String id = input.ask("Введите id заявки:");
			Item item = tracker.findById(id);
			if (item != null) {
				output.accept(String.format("%s\t%s\t%s\t%tD %tT", item.getId(), item.getName(), item.getDesc(), item.getCreated(), item.getCreated()));
			} else {
				output.accept("Заявка с id: " + id + " не найдена");
			}
			output.accept("----------------------------------------------");
		}	
	}
	
	/**
	 * Внутренний класс, поиск заявок по имени.
	 */
	public class FindByNameAction extends BaseAction {
		public FindByNameAction(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			output.accept(System.lineSeparator() + "------------ Поиск заявок по имени --------------");
			String name = input.ask("Введите имя заявки:");
			for (Item i: tracker.findByName(name)) {
				output.accept(String.format("%s\t%s\t%s\t%tD %tT", i.getId(), i.getName(), i.getDesc(), i.getCreated(), i.getCreated()));
			}
			output.accept("-------------------------------------------------");
		}	
	}
	
		/**
	 * Внутренний класс, выход из программы.
	 */
	public class ExitProgram extends BaseAction {
		public ExitProgram(int key, String name) {
			super(key, name);
		}

		@Override
		public void execute(Input input, Tracker tracker) {
			output.accept(System.lineSeparator() + "Завершение работы программы !");
		}	
	}
}