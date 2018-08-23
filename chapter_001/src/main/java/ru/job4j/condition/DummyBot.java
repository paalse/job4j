package ru.job4j.condition;


/**
 * Программа "глупый бот".
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class DummyBot {

    /**
     * Отвечает на вопросы.
     *
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {

        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";

        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {

            rsl = "До скорой встречи.";
        } else {
            rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        }
        return rsl;
    }
}
