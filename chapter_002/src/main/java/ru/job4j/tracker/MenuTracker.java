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
     * Константа меню для добавления новой заявки.
     */
    private static final int ADD = 0;
	
	/**
     * Константа меню для редактирования заявки.
     */
    private static final int REPLACE = 1;
	
	/**
     * Константа меню для удаления заявки.
     */
    private static final int DELETE = 2;
	
	/**
     * Константа меню для отображения всех заявок.
     */
    private static final int SHOW_ALL = 3;
	
	/**
     * Константа меню для поиска заявки по ID.
     */
    private static final int FIND_BY_ID = 4;

	/**
     * Константа меню для поиска заявки по имени.
     */
    private static final int FIND_BY_NAME = 5;

    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = 6;
	
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
        this.actions.add(new AddAction());
        this.actions.add(new ReplaceAction());
        this.actions.add(new DeleteAction());
        this.actions.add(new ShowAllAction());
        this.actions.add(new FindByIdAction());
        this.actions.add(new FindByNameAction());
        this.actions.add(new ExitProgram());
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
	public class AddAction implements UserAction {
		@Override
		public int key() {
			return ADD;
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

		@Override
		public String info() {
			return "0. Create new item";
		}
	}
	
	/**
	 * Внутренний класс, изменение заявки.
	 */
	public class ReplaceAction implements UserAction {
		@Override
		public int key() {
			return REPLACE;
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

		@Override
		public String info() {
			return "1. Edit item";
		}
	}
	
	/**
	 * Внутренний класс, удаление заявки.
	 */
	public class DeleteAction implements UserAction {
		@Override
		public int key() {
			return DELETE;
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

		@Override
		public String info() {
			return "2. Delete item";
		}
	}
	
	/**
	 * Внутренний класс, отображение всех заявок.
	 */
	public class ShowAllAction implements UserAction {
		@Override
		public int key() {
			return SHOW_ALL;
		}

		@Override
		public void execute(Input input, Tracker tracker) {
	        System.out.println(System.lineSeparator() + "------------ Отображение всех заявок --------------");
			for (Item i: tracker.findAll()) {
				System.out.println(String.format("%s\t%s\t%s\t%tD %tT", i.getId(), i.getName(), i.getDesc(), i.getCreated(), i.getCreated()));
			}
			System.out.println("---------------------------------------------------");
		}

		@Override
		public String info() {
			return "3. Show all items";
		}
	}
	
	/**
	 * Внутренний класс, поиск заявки по id.
	 */
	public class FindByIdAction implements UserAction {
		@Override
		public int key() {
			return FIND_BY_ID;
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

		@Override
		public String info() {
			return "4. Find item by Id";
		}
	}
	
	/**
	 * Внутренний класс, поиск заявок по имени.
	 */
	public class FindByNameAction implements UserAction {
		@Override
		public int key() {
			return FIND_BY_NAME;
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

		@Override
		public String info() {
			return "5. Find items by name";
		}
	}
	
		/**
	 * Внутренний класс, выход из программы.
	 */
	public class ExitProgram implements UserAction {
		@Override
		public int key() {
			return EXIT;
		}

		@Override
		public void execute(Input input, Tracker tracker) {
	        System.out.println(System.lineSeparator() + "Завершение работы программы !");
		}	

		@Override
		public String info() {
			return "6. Exit Program";
		}
	}
}