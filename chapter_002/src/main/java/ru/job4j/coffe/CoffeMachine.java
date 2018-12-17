package ru.job4j.coffe;

import java.util.Arrays;

/**
 * Расчет сдачи, кофе-машиной.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class CoffeMachine {
    public int[] changes(int value, int price) {
        int[] result = new int[100];    //Массив с результаом
        int cnt = 0;                    //Счетчик позиции массива с результатом
        int[] coins = {10, 5, 2, 1};    //Доступные для сдачи монеты
        int temp = value - price;       //Не обработанная сдача

        while (temp > 0) {
            for (int coin: coins) {
                if (temp < coin) {
                    continue;
                }
                for (int j = 0; j < temp / coin; j++) {
                    result[cnt] = coin;
                    cnt++;
                }
                temp = temp % coin;
            }
        }
        return Arrays.copyOf(result, cnt);
    }
}