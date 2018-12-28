package ru.job4j.lite;

import java.util.ArrayList;
import java.util.List;

//import static java.lang.String.format;

public class ListExample {
    public static void main(String args[]) {
        List<Integer> myList = new ArrayList<>();
        myList.add(456);
        System.out.println(myList.get(0));

        myList.add(1, 34);
        System.out.println(myList.get(1));

        List<Integer> myList1 = new ArrayList<>();
        myList1.add(55);
        myList1.add(66);
        myList.addAll(myList1);
        System.out.println(String.format("Index 55: %s", myList.indexOf(55)));
        System.out.println(String.format("Index 55: %s", myList.lastIndexOf(55)));

        System.out.println(myList.get(2));
        myList.remove(2);
        System.out.println(myList.get(2));

        System.out.println("------");
        System.out.println(String.format("Size: %s", myList.size()));

        System.out.println("------");
        myList.add(456); // Дает возможность добавления дубликатов
        for (Integer value : myList) {
            System.out.println(value);
        }

    }
}