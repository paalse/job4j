package ru.job4j.lite;

import java.util.*;
import java.util.function.Consumer;

public class ListExampleGenerics {
    static class User {
        private final String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "User {name'" + name + '\'' +"}";
        }
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("Alex"));
        boolean result = users.contains(new User("Alex"));
        System.out.println(result);

        System.out.println("----------Без итератора-----------");
        users.addAll(Arrays.asList(new User("Ivan"), new User("Petr")));
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("--------С итератором-------------");
        Iterator<User> it = users.iterator();
    /*
        System.out.println(it.next());
        System.out.println(it.next());
    */
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("--------Stream API-------------");
        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });

        System.out.println("--------Лямбда-------------");
        users.forEach(user -> System.out.println(user));

        System.out.println("--------Еще более сокращенный вывод-------------");
        users.forEach(System.out::println);
    }

}

