package ru.job4j.tracker;

import java.util.*;

/**
 * Класс ввода данных в консоли.
 * @author Aleksey Pavlov (mailto:paalse@list.ru) 
 */
public class ConsoleInput implements Input {
	
	private Scanner scanner = new Scanner(System.in);

	@Override
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}

	@Override
	public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Пункт отсутствует в меню.");
        }
        return key;
    }
}