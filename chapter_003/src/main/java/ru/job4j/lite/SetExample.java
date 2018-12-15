package ru.job4j.lite;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> mySet = new TreeSet<Integer>();
        mySet.add(3);
        mySet.add(1);
        mySet.add(4);
        mySet.add(0);

        mySet.add(4);   //Дубликаты в коллекцию TreeSet вставить нельзя

        for (Integer value : mySet) {
            System.out.println(value);
        }
    }
}
