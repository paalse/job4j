package ru.job4j.tracker;

/**
 * Класс пользовательского интерфейса.
 * @author Aleksey Pavlov (mailto:paalse@list.ru) 
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
	
	/**
     * Константа меню для редактирования заявки.
     */
    private static final String REPLACE = "1";
	
	/**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "2";
	
	/**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOWALL = "3";
	
	/**
     * Константа меню для поиска заявки по ID.
     */
    private static final String FIND_BY_ID = "4";

	/**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (REPLACE.equals(answer)) {
				this.replaceItem(); 
            } else if (DELETE.equals(answer)) {				
				this.deleteItem(); 
            } else if (SHOWALL.equals(answer)) {			
				this.showAllItem(); 			
            } else if (FIND_BY_ID.equals(answer)) {			
				this.findById(); 
            } else if (FIND_BY_NAME.equals(answer)) {			
				this.findByName(); 			
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавлене новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println(System.lineSeparator() + "------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки:");
        String desc = this.input.ask("Введите описание заявки:");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Создана новая заявка с id: " + item.getId());
    	System.out.println("---------------------------------------------------");
	}

	/**
     * Метод реализует редактирование имеющейся заявки.
     */
    private void replaceItem() {
		System.out.println(System.lineSeparator() + "------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки:");
		String name = this.input.ask("Введите новое имя заявки:");
        String desc = this.input.ask("Введите новое описание заявки:");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) { 
			System.out.println("Заявка с id: " + id + " успешно отредактирована");
		} else {
			System.out.println("Заявка с id: " + id + " не найдена");
		}
		System.out.println("-------------------------------------------------");
    }
	
	/**
     * Метод реализует удаление имеющейся заявки.
     */
    private void deleteItem() {
		System.out.println(System.lineSeparator() + "------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки:");
        if (this.tracker.delete(id)) { 
			System.out.println("Заявка с Id: " + id + " успешно удалена");
		} else {
			System.out.println("Заявка с id: " + id + " не найдена");
		}
		System.out.println("-------------------------------------------");
	}

	/**
     * Метод реализует вывода всех заявок.
     */
    private void showAllItem() {
        System.out.println(System.lineSeparator() + "------------ Отображение всех заявок --------------");
		for (Item i: this.tracker.findAll()) {
			System.out.println(String.format("%s\t%s\t%s\t%tD %tT", i.getId(), i.getName(), i.getDesc(), i.getCreated(), i.getCreated()));
		}
		System.out.println("---------------------------------------------------");
    }	
	
	/**
     * Метод реализует поиск заявки по ID.
     */
    private void findById() {
        System.out.println(System.lineSeparator() + "------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите id заявки:");
		Item item = this.tracker.findById(id); 
		if (item != null) {
			System.out.println(String.format("%s\t%s\t%s\t%tD %tT", item.getId(), item.getName(), item.getDesc(), item.getCreated(), item.getCreated()));
		} else {
			System.out.println("Заявка с id: " + id + " не найдена");
		}
		System.out.println("----------------------------------------------");
    }	

	/**
     * Метод реализует поиск заявок по имени.
     */
    private void findByName() {
        System.out.println(System.lineSeparator() + "------------ Поиск заявок по имени --------------");
        String name = this.input.ask("Введите имя заявки:");
		for (Item i: this.tracker.findByName(name)) {
			System.out.println(String.format("%s\t%s\t%s\t%tD %tT", i.getId(), i.getName(), i.getDesc(), i.getCreated(), i.getCreated()));
		}
		System.out.println("-------------------------------------------------");
    }	
	
	/**
	 * Отображение пользовательского меню.
	 */
    private void showMenu() {
		System.out.println(System.lineSeparator() + "--------- Menu ---------");
        System.out.println("0. Create new item");
		System.out.println("1. Edit item");
		System.out.println("2. Delete item");
        System.out.println("3. Show all items");
		System.out.println("4. Find item by Id");
		System.out.println("5. Find items by name");
		System.out.println("6. Exit Program");
        System.out.println("------------------------");
    }

    /**
     * Запускт программы.
     * @param args - входные параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}