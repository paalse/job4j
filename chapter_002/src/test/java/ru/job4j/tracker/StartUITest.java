package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;


public class StartUITest {

	/**
	 * Проверка создания новой заявки.
	 */
	@Test
	public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
		Tracker tracker = new Tracker();     // создаём Tracker
		Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
		new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
		assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
	}

	/**
	 * Проверка изменения заявки.
	 */
	@Test
	public void whenUpdateThenTrackerHasUpdatedValue() {
		// создаём Tracker
		Tracker tracker = new Tracker();
		//Напрямую добавляем заявку
		Item item = tracker.add(new Item("test name", "desc"));
		//создаём StubInput с последовательностью действий(производим замену заявки)
		Input input = new StubInput(new String[]{"1", item.getId(), "test replace", "replace item", "6"});
		// создаём StartUI и вызываем метод init()
		new StartUI(input, tracker).init();
		// проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
		assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
	}
	
	/**
	 * Проверка удаления заявки.
	 */
	@Test
	public void whenDeleteThenTrackerNotFindItem() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("test name", "desc"));
		Input input = new StubInput(new String[]{"2", item.getId(), "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findById(item.getId()), is(nullValue()));
	}
	
	/**
	 * Проверка выборки всех заявок.
	 */
	@Test
	public void whenFindAllItems() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("name", "desc"));
		Item item1 = tracker.add(new Item("name1", "desc"));
		Item item2 = tracker.add(new Item("name2", "desc"));
		Item[] expected = new Item[]{item, item1, item2};
		Input input = new StubInput(new String[]{"3", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll(), is(expected));
	}
	
	/**
	 * Проверка выборки заявок по id.
	 */
	@Test
	public void whenFindItemById() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("name", "desc"));
		Item item1 = tracker.add(new Item("name1", "desc"));
		Item item2 = tracker.add(new Item("name2", "desc"));
		Item expected = item1;
		Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findById(item1.getId()), is(item1));
	}
	
		
	/**
	 * Проверка выборки заявок по имени.
	 */
	@Test
	public void whenFindItemsByName() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("name", "desc"));
		Item item1 = tracker.add(new Item("name1", "desc"));
		Item item2 = tracker.add(new Item("name1", "desc"));
		Item[] expected = new Item[]{item1, item2};
		Input input = new StubInput(new String[]{"4", item1.getName(), "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findByName(item1.getName()), is(expected));
	}
}