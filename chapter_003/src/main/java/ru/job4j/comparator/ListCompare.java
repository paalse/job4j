package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int len1 = left.length();
        int len2 = right.length();
        int result = len1 - len2;
        for (int k = 0; k < Math.min(len1, len2); k++) {
            char c1 = left.charAt(k);
            char c2 = right.charAt(k);
            if (c1 != c2) {
                result = c1 - c2;
                break;
            }
        }
        return result;
    }
}