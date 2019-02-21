package ru.job4j.school;

/**
 * Класс описывающий студента
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Student {
    private String family;
    private String name;
    private Integer score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String family, String name, Integer score) {
        this.family = family;
        this.name = name;
        this.score = score;
    }

    /**
     * Получение фамилии
     *
     * @return
     */
    public String getFamily() {
        return family;
    }

    /**
     * Установка фамилии
     *
     * @return
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**
     * Получение имени
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Установка имени
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получение баллов
     *
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Установка баллов
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{"
                + "family='" + family + '\''
                + "name='" + name + '\''
                + ", score=" + score
                + '}';
    }
}