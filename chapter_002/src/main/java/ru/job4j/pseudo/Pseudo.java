package ru.job4j.pseudo;

/**
 * Изучение полиморфизма, вывод геометрических фигур.
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Pseudo {
	public static void main(String[] args) {
		new Paint().draw(new Square());
		System.out.println(System.lineSeparator());
		new Paint().draw(new Triangle());
	}
}