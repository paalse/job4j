package ru.job4j.condition;

/**
 * Программа расчета расстояния между точками.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор.
     *
     * @param x - значение координаты Х.
     * @param y - значение координаты Y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расчет расстояния между точками.
     *
     * @param that - координаты точек.
     * @return - расстояние между точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    /**
     * Main.
     *
     * @param args - аргументы.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}