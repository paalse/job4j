package ru.job4j.list;

public class User {
    private Integer id;
    private String name;
    private String sity;

    User (int id, String name, String sity) {
        this.id = id;
        this.name = name;
        this.sity = sity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }
}
