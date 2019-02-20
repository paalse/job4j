package ru.job4j.school;

/**
 * Класс описывающий студента
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Student {
    private String name;
    private Integer score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", score=" + score
                + '}';
    }
}