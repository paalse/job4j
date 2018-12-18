package ru.job4j.coffe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Расчет сдачи, кофе-машиной.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class CoffeMachine {
    public Integer[] changes(int value, int price) {
        List<Integer> result = new LinkedList<>();    //Перечень монет для выдачи сдачи
        int[] coins = {10, 5, 2, 1};                  //Доступные для сдачи монеты
        int temp = value - price;                     //Не обработанная сдача

        while (temp > 0) {
            for (int coin: coins) {
                if (temp < coin) {
                    continue;
                }
                for (int j = 0; j < temp / coin; j++) {
                    result.add(coin);
                }
                temp = temp % coin;
            }
        }
        return result.toArray(new Integer[0]);
    }
}