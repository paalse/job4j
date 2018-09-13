package ru.job4j.loop;

/**
 * Программа шахматная доска.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String separator = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                 if (((i + j) % 2) == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(separator);
        }
        return screen.toString();
    }
}