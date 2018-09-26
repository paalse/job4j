package ru.job4j.tracker;

import java.util.Random;
import java.util.Arrays;

/**
 * Трекер для учета заявок
 * @author Aleksey Pavlov (mailto:paalse@list.ru) 
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
	private static final Random RN = new Random();
	
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item - новая заявка.
	 * @return - заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return Уникальный ключ заявки.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

	/**
	 * Метод изменяет содержимое заяки.
	 * @param id - id заявки, которую нужно изменить.
	 * @param item - новое содержимое заявки.
	 */
	public void replace(String id, Item item) {
		if (id != null) {
			for (int i = 0; i < this.items.length; i++) {
				if (this.items[i].getId().equals(id)) {
					this.items[i] = item;
					break;
				}
			}
		}
	}
		
	/**
	 * Метод удаляет заявку.
	 * @param id - id заявки.
	 */
	public void delete(String id) {
		if (id != null) {
			for (int i = 0; i < this.items.length; i++) {
				if (this.items[i].getId().equals(id)) {
					this.items[i] = null;
					System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
					position--;
					break;
				}
			}	
		}
	}
		
	/**
	 * Метод возвращает все заявки.
	 * @return - все заявки.
	 */
	public Item[] findAll() {
		int cnt = 0;
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i] != null) { 
				cnt++;
			}
		}
		return Arrays.copyOf(this.items, cnt);
	}
	
	/**
	 * Метод поиска заявки по имени.
	 * @param name - имя заявки.
	 * @return - все заявки по конкретному имени.
	 */
	public Item[] findByName(String name) {
		Item[] result = new Item[this.items.length];
		int cnt = 0;
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i] != null) {
				if (this.items[i].getName().equals(name)) {
					result[cnt] = this.items[i];
					cnt++;
				}
			} else { 
				break; 
			}
		}
		return Arrays.copyOf(result, cnt);
	}
	
	/**
	 * Метод поиска заявки по id.
	 * @param id - 	id заявки.
	 * @return - найденая заявка.
	 */
	public Item findById(String id) {
		Item result = null;
		if (id != null) {		
			for (Item element: this.items) {
				if (element != null) {
					if (element.getId().equals(id)) {
						result = element;
						break;
					}
				} else {
					break;
				}
			}
		}
		return result;
	}
}