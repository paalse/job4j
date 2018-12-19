package ru.job4j.search;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int n = tasks.size();
        for (Task element : tasks) {
            if(element.getPriority() > task.getPriority()) {
                n = tasks.indexOf(element);
                break;
            }
        }
        tasks.add(n, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}