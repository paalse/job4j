package ru.job4j.chess.firuges;

/**
 * @author Pavlov Aleksey (mailto:paalse@list.ru)
 * @version $Id$
 * @since 0.1
 */
public class OccupiedWayException extends Exception {
   public OccupiedWayException(String msg) {
       System.out.println(msg);
   }
}
