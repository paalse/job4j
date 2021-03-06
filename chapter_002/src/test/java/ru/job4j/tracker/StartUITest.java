package ru.job4j.tracker;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream stdout = new PrintStream(out);

    private final Consumer<String> output = new Consumer<String>() {
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    private final String menu = new StringBuilder()
            .append(System.lineSeparator() + "--------- Menu ---------" + System.lineSeparator())
            .append("0. Create new item" + System.lineSeparator())
            .append("1. Edit item" + System.lineSeparator())
            .append("2. Delete item" + System.lineSeparator())
            .append("3. Show all items" + System.lineSeparator())
            .append("4. Find item by Id" + System.lineSeparator())
            .append("5. Find items by name" + System.lineSeparator())
            .append("6. Exit Program" + System.lineSeparator())
            .append("------------------------" + System.lineSeparator())
            .toString();

    /**
     * Метод выполняется до начала теста.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Метод выполняется после окончания теста.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Проверка создания новой заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new ArrayList<>(Arrays.asList("0", "test name", "desc", "y")));   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
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
        Input input = new StubInput(new ArrayList<>(Arrays.asList("1", item.getId(), "test replace", "replace item", "y")));
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
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
        Input input = new StubInput(new ArrayList<>(Arrays.asList("2", item.getId(), "y")));
        new StartUI(input, tracker, output).init();
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
        List<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item1);
        expected.add(item2);
        Input input = new StubInput(new ArrayList<>(Arrays.asList("3", "y")));
        new StartUI(input, tracker, output).init();
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
        Input input = new StubInput(new ArrayList<>(Arrays.asList("4", item1.getId(), "y")));
        new StartUI(input, tracker, output).init();
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
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        Input input = new StubInput(new ArrayList<>(Arrays.asList("4", item1.getName(), "y")));
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findByName(item1.getName()), is(expected));
    }

    /**
     * Проверка вывода на консоль выборки заявок по id.
     */
    @Test
    public void whenConsoleFindAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Item item1 = tracker.add(new Item("name1", "desc"));
        Item item2 = tracker.add(new Item("name2", "desc"));
        Input input = new StubInput(new ArrayList<>(Arrays.asList("4", item1.getId(), "y")));
        new StartUI(input, tracker, output).init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append(menu)
                .append(System.lineSeparator() + "------------ Поиск заявки по ID --------------" + System.lineSeparator())
                .append(String.format("%s\t%s\t%s\t%tD %tT", item1.getId(), item1.getName(), item1.getDesc(), item1.getCreated(), item1.getCreated()) + System.lineSeparator())
                .append("----------------------------------------------" + System.lineSeparator())
                .toString();
        assertThat(result, is(expected));
    }

    /**
     * Проверка вывода на консоль выборки всех заявок.
     */
    @Test
    public void whenConsoleFindItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Item item1 = tracker.add(new Item("name1", "desc"));
        Item item2 = tracker.add(new Item("name2", "desc"));
        Input input = new StubInput(new ArrayList<>(Arrays.asList("3", "y")));
        new StartUI(input, tracker, output).init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append(menu)
                .append(System.lineSeparator() + "------------ Отображение всех заявок --------------" + System.lineSeparator())
                .append(String.format("%s\t%s\t%s\t%tD %tT", item.getId(), item.getName(), item.getDesc(), item.getCreated(), item.getCreated()) + System.lineSeparator())
                .append(String.format("%s\t%s\t%s\t%tD %tT", item1.getId(), item1.getName(), item1.getDesc(), item1.getCreated(), item1.getCreated()) + System.lineSeparator())
                .append(String.format("%s\t%s\t%s\t%tD %tT", item2.getId(), item2.getName(), item2.getDesc(), item2.getCreated(), item2.getCreated()) + System.lineSeparator())
                .append("---------------------------------------------------" + System.lineSeparator())
                .toString();
        assertThat(result, is(expected));
    }
}