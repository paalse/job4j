package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверка строк.
     *
     * @param xo true - проверка по Х, false - проверка по O.
     * @return true - если заполнена линия, false - если линия не заполнена.
     */
    public boolean fillGoriz(boolean xo) {
        boolean res = false;
        for (int i = 0; i < this.table.length; i++) {
            int count = 0;
            for (int j = 0; j < this.table.length; j++) {

                if (xo) {
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
     * @param xo true - проверка по Х, false - проверка по O.
     * @return true - если заполнена линия, false - если линия не заполнена.
     */
    public boolean fillVert(boolean xo) {
        boolean res = false;
        for (int i = 0; i < this.table.length; i++) {
            int count = 0;
            for (int j = 0; j < this.table.length; j++) {

                if (xo) {
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
     * @param xo true - проверка по Х, false - проверка по O.
     * @return true - если заполнена линия, false - если линия не заполнена.
     */
    public boolean fillDiag(boolean xo) {
        boolean res = false;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < this.table.length; i++) {
            if (xo) {
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
        if ((count1 == this.table.length) || (count2 == this.table.length)) res = true;
        return res;
    }

    public boolean isWinnerX() {
        return fillGoriz(true) || fillVert(true) || fillDiag(true);
    }

    public boolean isWinnerO() {
        return fillGoriz(false) || fillVert(false) || fillDiag(false);
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
                }
            }
        }
        return res;
    }
}
