package ru.job4j.sort;

import java.util.Comparator;

/**
 * Пользователь, с переопределением compareTo
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + this.name + ", " + this.age + "]";
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}
