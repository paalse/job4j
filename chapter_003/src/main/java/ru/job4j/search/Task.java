package ru.job4j.search;

public class Task {
    private String desc;
    private Integer priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getPriority() {
        return priority;
    }
}