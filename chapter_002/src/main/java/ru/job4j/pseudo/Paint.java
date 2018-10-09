package ru.job4j.pseudo;

/**
 * Вывод на консоль геометрической фигуры. 
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}