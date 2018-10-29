package ru.job4j.tracker;

import java.util.*;

/**
 * Класс пользовательского интерфейса.
 * @author Aleksey Pavlov (mailto:paalse@list.ru) 
 */
public class StartUI {

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
		MenuTracker menu = new MenuTracker(this.input, this.tracker);
		List<Integer> range = new ArrayList<>();
		menu.fillActions();
		for (int i = 0; i < menu.getActionsLentgh(); i++) {
			range.add(i);
		}
		do {
			menu.show();
			menu.select(input.ask("Select:", range));
		} while (!"y".equals(this.input.ask("Exit?(y): ")));
	}

    /**
     * Запускт программы.
     * @param args - входные параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}