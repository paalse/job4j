package ru.job4j.tracker;

import java.util.*;

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
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
		System.out.println(System.lineSeparator() + "--------- Menu ---------");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
		System.out.println("------------------------");
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
			System.out.println(System.lineSeparator() + "------------ Добавление новой заявки --------------");
			String name = input.ask("Введите имя заявки:");
			String desc = input.ask("Введите описание заявки:");
			Item item = new Item(name, desc);
			tracker.add(item);
			System.out.println("Создана новая заявка с id: " + item.getId());
			System.out.println("---------------------------------------------------");
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
			System.out.println(System.lineSeparator() + "------------ Редактирование заявки --------------");
			String id = input.ask("Введите id заявки:");
			String name = input.ask("Введите новое имя заявки:");
			String desc = input.ask("Введите новое описание заявки:");
			Item item = new Item(name, desc);
			if (tracker.replace(id, item)) {
				System.out.println("Заявка с id: " + id + " успешно отредактирована");
			} else {
				System.out.println("Заявка с id: " + id + " не найдена");
			}
			System.out.println("-------------------------------------------------");
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
			System.out.println(System.lineSeparator() + "------------ Удаление заявки --------------");
			String id = input.ask("Введите id заявки:");
			if (tracker.delete(id)) {
				System.out.println("Заявка с Id: " + id + " успешно удалена");
			} else {
				System.out.println("Заявка с id: " + id + " не найдена");
			}
			System.out.println("-------------------------------------------");
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
	        System.out.println(System.lineSeparator() + "------------ Отображение всех заявок --------------");
			for (Item i: tracker.findAll()) {
				System.out.println(String.format("%s\t%s\t%s\t%tD %tT", i.getId(), i.getName(), i.getDesc(), i.getCreated(), i.getCreated()));
			}
			System.out.println("---------------------------------------------------");
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
			System.out.println(System.lineSeparator() + "------------ Поиск заявки по ID --------------");
			String id = input.ask("Введите id заявки:");
			Item item = tracker.findById(id);
			if (item != null) {
				System.out.println(String.format("%s\t%s\t%s\t%tD %tT", item.getId(), item.getName(), item.getDesc(), item.getCreated(), item.getCreated()));
			} else {
				System.out.println("Заявка с id: " + id + " не найдена");
			}
			System.out.println("----------------------------------------------");
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
	        System.out.println(System.lineSeparator() + "------------ Поиск заявок по имени --------------");
			String name = input.ask("Введите имя заявки:");
			for (Item i: tracker.findByName(name)) {
				System.out.println(String.format("%s\t%s\t%s\t%tD %tT", i.getId(), i.getName(), i.getDesc(), i.getCreated(), i.getCreated()));
			}
			System.out.println("-------------------------------------------------");
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
	        System.out.println(System.lineSeparator() + "Завершение работы программы !");
		}	
	}
}