package ru.job4j.lite;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("Aleksey Pavlov", 3);
        students.put("Aleksander Ivanov", 5);

        students.put("Aleksey Pavlov", 5); // Перезатирает значение

        System.out.println(students.get("Aleksey Pavlov"));

        for (String student : students.keySet()) {
            System.out.println(String.format("%s : %s", student, students.get(student)));
        }

        for (Integer scope : students.values()) {
            System.out.println(String.format("%s", scope));
        }
    }
}