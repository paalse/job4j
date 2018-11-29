package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.black.*;


public class FigureTest {

    /**
     *  Тестирование правильности хода ладьи
     */
    @Test
    public void whenRookBlackMove() throws ImposibleMoveException {
        RookBlack rookBlack = new RookBlack(Cell.A1);
        Cell[] steps = new Cell[] {Cell.A2, Cell.A3};
        assertThat(rookBlack.way(Cell.A1, Cell.A3), is(steps));
    }

    /**
     *  Тестирование исключения неверного хода ладьи
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenRookBlacWrongMove() throws ImposibleMoveException {
        RookBlack rookBlack = new RookBlack(Cell.A1);
        Cell[] steps = new Cell[] {Cell.A2, Cell.A3};
        assertThat(rookBlack.way(Cell.A1, Cell.B3), is(steps));
    }

    /**
     *  Тестирование правильности хода слона
     */
    @Test
    public void whenBishopBlackMove() throws ImposibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell[] steps = new Cell[] {Cell.D7, Cell.E6};
        assertThat(bishopBlack.way(Cell.C8, Cell.E6), is(steps));
    }

    /**
     *  Тестирование исключения неверного хода слона
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenBishopBlackWrongMove() throws ImposibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell[] steps = new Cell[] {Cell.D7, Cell.E6};
        assertThat(bishopBlack.way(Cell.C8, Cell.C6), is(steps));
    }
}