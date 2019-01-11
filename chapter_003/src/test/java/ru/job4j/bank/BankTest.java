package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Тесты банковских переводов
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class BankTest {

    /**
     * Проверка добавления пользователя
     */
    @Test
    public void addUserTest() {
        Bank bank = new Bank();
        User user = new User("Alex", "2345 123123");
        bank.addUser(user);
        assertThat(bank.getUserByPasport("2345 123123"), is(user));
    }

    /**
     * Проверка удаления пользователя
     */
    @Test
    public void deleteUserTest() {
        Bank bank = new Bank();
        User user = new User("Alex", "2345 123123");
        bank.addUser(user);
        bank.deleteUser(user);
        assertNull(bank.getUserByPasport("2345 123123"));

    }

    /**
     * Проверка добавления счета пользователю
     */
    @Test
    public void addAccountToUserTest() {
        Bank bank = new Bank();
        User user = new User("Alex", "2345 123123");
        bank.addUser(user);
        Account account = new Account("1234567890", 10.5);
        bank.addAccountToUser("2345 123123", account);
        assertThat(bank.getAccountByRequisite(user, "1234567890"), is(account));
    }

    /**
     * Проверка удаления счета у пользователя
     */
    @Test
    public void deleteAccountFromUserTest() {
        Bank bank = new Bank();
        User user = new User("Alex", "2345 123123");
        bank.addUser(user);
        Account account = new Account("1234567890", 10.5);
        bank.addAccountToUser("2345 123123", account);
        bank.deleteAccountFromUser("2345 123123", account);
        assertNull(bank.getAccountByRequisite(user, "1234567890"));
    }

    /**
     * Проверка получения счетов пользователя
     */
    @Test
    public void getUserAccountsTest() {
        Bank bank = new Bank();
        User user = new User("Alex", "2345 123123");
        bank.addUser(user);
        Account account = new Account("1234567890", 10.5);
        Account account1 = new Account("2234567892", 24.3);
        bank.addAccountToUser("2345 123123", account);
        bank.addAccountToUser("2345 123123", account1);
        List<Account> expected = new ArrayList<>();
        expected.add(account);
        expected.add(account1);
        assertThat(bank.getUserAccounts("2345 123123"), is(expected));
    }

    /**
     * Проверка перевода денег со счета на счет.
     * Проверяем сумму на счете получателе.
     */
    @Test
    public void transferMoneyTest() {
        Bank bank = new Bank();
        User user = new User("Alex", "2345 123123");
        bank.addUser(user);
        Account account = new Account("1234567890", 10.5);
        Account account1 = new Account("2234567892", 24.3);
        bank.addAccountToUser("2345 123123", account);
        bank.addAccountToUser("2345 123123", account1);
        bank.transferMoney("2345 123123", "1234567890", "2345 123123", "2234567892", 5.1);
        assertThat(bank.getAccountByRequisite(user, "2234567892").getValue(), is(29.4));
    }

    /**
     * Проверка перевода денег со счета на счет.
     * Проверяем сумму на счете отправителе.
     */
    @Test
    public void transferMoneyTest1() {
        Bank bank = new Bank();
        User user = new User("Alex", "2345 123123");
        bank.addUser(user);
        Account account = new Account("1234567890", 10.5);
        Account account1 = new Account("2234567892", 24.3);
        bank.addAccountToUser("2345 123123", account);
        bank.addAccountToUser("2345 123123", account1);
        bank.transferMoney("2345 123123", "1234567890", "2345 123123", "2234567892", 5.1);
        assertThat(bank.getAccountByRequisite(user, "1234567890").getValue(), is(5.4));
    }
}