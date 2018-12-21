package ru.job4j.list;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Преобразования списка в двухмерный массив.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ConvertList2Array {

    /**
     * Преобразование списка в массив
     * @param list - список
     * @param rows - кол-во строк создаваемого массива
     * @return - массив
     * @throws NullPointerException
     */
    public int[][] toArray(List<Integer> list, int rows) throws NullPointerException {
        if (rows == 0) {
            throw new NullPointerException("Количество строк не может быть равным нулю !");
        }
        int cells = 0;
        if (list.size() % rows == 0) {
            cells = list.size() / rows;
        } else {
            cells = list.size() / rows + 1;
        }
        int[][] array = new int[rows][cells];
        int i = 0;
        for (int[] innerArray: array) {
            int j = 0;
            for(int data: innerArray) {
                if ((i * cells + j) < list.size()) {
                    array[i][j] = list.get(i * cells + j);
                }
                j++;
            }
            i++;
        }
        return array;
    }

    /**
     * Преобразование нескольких списка из нескольких массивов в один список
     * @param list
     * @return - список
     */
    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] mass : list) {
            for (int element : mass) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Преобразование нескольких списка из нескольких массивов в один список
     * @param list
     * @return - список
     */
    public List<Integer> convert1 (List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] mass : list) {
            result.addAll(Arrays.asList(ArrayUtils.toObject(mass)));
        }
        return result;
    }
}