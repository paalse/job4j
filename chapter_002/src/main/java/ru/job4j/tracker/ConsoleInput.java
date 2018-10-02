package ru.job4j.tracker;

import java.util.*;

/**
 * Класс ввода данных в консоли.
 * @author Aleksey Pavlov (mailto:paalse@list.ru) 
 */
public class ConsoleInput implements Input {
	
	private Scanner scanner = new Scanner(System.in);
	
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}
}