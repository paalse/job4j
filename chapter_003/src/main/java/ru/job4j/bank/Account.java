package ru.job4j.bank;

/**
 * Класс описывающий банковский счет
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Account {
    private String requisites; //реквизиты счёта
    private double value; //кол-во денег

    public Account(String requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }
}