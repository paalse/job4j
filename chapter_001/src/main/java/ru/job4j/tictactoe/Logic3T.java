package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверка строк.
     *
     * @param val true - проверка по Х, false - проверка по O.
     * @return true - если заполнена линия, false - если линия не заполнена.
     */
    public boolean checkRowFill(boolean val) {
        boolean res = false;
        for (int i = 0; i < this.table.length; i++) {
            int count = 0;
            for (int j = 0; j < this.table.length; j++) {
                if (val) {
                    if (this.table[i][j].hasMarkX()) {
                        count++;
                    }
                } else {
                    if (this.table[i][j].hasMarkO()) {
                        count++;
                    }
                }
            }
            if (count == this.table.length) {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * Проверка столбцов.
     *
     * @param val true - проверка по Х, false - проверка по O.
     * @return true - если заполнена линия, false - если линия не заполнена.
     */
    public boolean checkColumnFill(boolean val) {
        boolean res = false;
        for (int i = 0; i < this.table.length; i++) {
            int count = 0;
            for (int j = 0; j < this.table.length; j++) {
                if (val) {
                    if (this.table[j][i].hasMarkX()) {
                        count++;
                    }
                } else {
                    if (this.table[j][i].hasMarkO()) {
                        count++;
                    }
                }
            }
            if (count == this.table.length) {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * Проверка диагоналей.
     *
     * @param val true - проверка по Х, false - проверка по O.
     * @return true - если заполнена линия, false - если линия не заполнена.
     */
    public boolean checkDiagonalFill(boolean val) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < this.table.length; i++) {
            if (val) {
                if (this.table[i][i].hasMarkX()) {
                    count1++;
                }
                if (this.table[i][this.table.length - i - 1].hasMarkX()) {
                    count2++;
                }
            } else {
                if (this.table[i][i].hasMarkO()) {
                    count1++;
                }
                if (this.table[i][this.table.length - i - 1].hasMarkO()) {
                    count2++;
                }
            }
        }
        return (count1 == this.table.length) || (count2 == this.table.length);
    }

    /**
     * Проверка победы крестиков.
     *
     * @return true - крестики победили.
     */
    public boolean isWinnerX() {
        return checkRowFill(true) || checkColumnFill(true) || checkDiagonalFill(true);
    }

    /**
     * Проверка победы ноликов.
     *
     * @return true - нолики победили.
     */
    public boolean isWinnerO() {
        return checkRowFill(false) || checkColumnFill(false) || checkDiagonalFill(false);
    }

    /**
     * Проверка заполнения всех полей таблицы.
     *
     * @return false - все поля заполнены.
     */
    public boolean hasGap() {
        boolean res = false;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (this.table[i][j].hasMarkX() == this.table[i][j].hasMarkO()) {
                    res = true;
                    break;
                }
            }
            if (res) {
                break;
            }
        }
        return res;
    }
}