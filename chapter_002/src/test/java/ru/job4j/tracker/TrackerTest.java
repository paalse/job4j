package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса Item.
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class TrackerTest {
	/**
	 * Проверка добавления новой заявки.
	 */
	@Test
	public void whenAddNewItemThenTrackerHasSameItem() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1", "testDescription", 123L);
		tracker.add(item);
		assertThat(tracker.findAll()[0], is(item));
	}

	/**
	 * Проверка изменения заяки.
	 */
	@Test
	public void whenReplaceNameThenReturnNewName() {
		Tracker tracker = new Tracker();
		Item previous = new Item("test1", "testDescription1", 123L);
		tracker.add(previous);
		Item next = new Item("test2", "testDescription2", 123L);
		next.setId(previous.getId());
		tracker.replace(previous.getId(), next);
		assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
	}
	
	/**
	 * Проверка удаления заяки из массива.
	 */
	 @Test
	public void whenDeleteItemThenReturnWithoutItem() {
		Tracker expected = new Tracker();
		Tracker tracker = new Tracker();
		Item first = new Item("test1", "testDescription1", 123L);
		tracker.add(first);
		Item second = new Item("test2", "testDescription2", 123L);
		tracker.add(second);
		expected.add(second);
		Item third = new Item("test3", "testDescription3", 123L);
		tracker.add(third);
		expected.add(third);
		tracker.delete(first.getId());
		assertThat(tracker.findAll(), is(expected.findAll()));
	}

	/**
	 * Проверка получения всех заявок.
	 */
	 @Test
	public void whenFindAll() {
		Tracker expected = new Tracker();
		Tracker tracker = new Tracker();
		Item first = new Item("test1", "testDescription1", 123L);
		tracker.add(first);
		expected.add(first);
		Item second = new Item("test2", "testDescription2", 123L);
		tracker.add(second);
		expected.add(second);
		Item third = new Item("test2", "testDescription3", 123L);
		tracker.add(third);
		expected.add(third);
		assertThat(tracker.findAll(), is(expected.findAll()));
	}
	
	/**
	 * Проверка поиска заявки по имени.
	 */
	 @Test
	public void whenFindByName() {
		Tracker expected = new Tracker();
		Tracker tracker = new Tracker();
		Item first = new Item("test1", "testDescription1", 123L);
		tracker.add(first);
		Item second = new Item("test2", "testDescription2", 123L);
		tracker.add(second);
		expected.add(second);
		Item third = new Item("test2", "testDescription3", 123L);
		tracker.add(third);
		expected.add(third);
		assertThat(tracker.findByName("test2"), is(expected.findAll()));
	}
	
	/**
	 * Проверка поиска заявки по Id.
	 */
	 @Test
	public void whenFindById() {
		Tracker expected = new Tracker();
		Tracker tracker = new Tracker();
		Item first = new Item("test1", "testDescription1", 123L);
		tracker.add(first);
		Item second = new Item("test2", "testDescription2", 123L);
		tracker.add(second);
		expected.add(second);
		Item third = new Item("test3", "testDescription3", 123L);
		tracker.add(third);
		assertThat(tracker.findById(second.getId()), is(second));
	}
}