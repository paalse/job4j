package ru.job4j.chess.firuges;

/**
 * @author Pavlov Aleksey (mailto:paalse@list.ru)
 * @version $Id$
 * @since 0.1
 */
public class ImposibleMoveException extends Exception {
    public ImposibleMoveException(String msg) {
        System.out.println(msg);
    }
}