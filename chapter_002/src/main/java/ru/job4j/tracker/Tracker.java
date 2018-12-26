package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Трекер для учета заявок
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     *
     * @param item - новая заявка.
     * @return - заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     *
     * @return Уникальный ключ заявки.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод изменяет содержимое заяки.
     *
     * @param id   - id заявки, которую нужно изменить.
     * @param item - новое содержимое заявки.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int count = 0;
        if (id != null) {
            while (count != this.items.size()) {
                if (this.items.get(count).getId().equals(id)) {
                    item.setId(id);
                    this.items.set(count, item);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод удаляет заявку.
     *
     * @param id - id заявки.
     */
    public boolean delete(String id) {
        boolean result = false;
        int count = 0;
        if (id != null) {
            while (count != this.items.size()) {
                if (this.items.get(count).getId().equals(id)) {
                    this.items.remove(count);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод возвращает все заявки.
     *
     * @return - все заявки.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод поиска заявки по имени.
     *
     * @param name - имя заявки.
     * @return - все заявки по конкретному имени.
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item element : items) {
            if (element.getName().equals(name)) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Метод поиска заявки по id.
     *
     * @param id - 	id заявки.
     * @return - найденая заявка.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item element : items) {
            if (element.getId().equals(id)) {
                result = element;
                break;
            }
        }
        return result;
    }
}