package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Банковские переводы
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Bank {
    private TreeMap<User, List<Account>> bank = new TreeMap<>();

    /**
     * Добавление пользователя
     *
     * @param user - объект "Пользователь"
     */
    public void addUser(User user) {
        this.bank.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаление пользователя
     *
     * @param user - объект "Пользователь"
     */
    public void deleteUser(User user) {
        this.bank.remove(user);
    }

    /**
     * Получить пользователя по паспорту
     *
     * @return объект "Пользователь"
     */
    public User getUserByPasport(String passport) {
        return this.bank.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findAny()
                .orElse(null);
    }

    /**
     * Добавить счёт пользователю
     *
     * @param passport - номер паспорта
     * @param account  - объект "Счет"
     */
    public void addAccountToUser(String passport, Account account) {
        int count = 0;
        count = this.bank.get(getUserByPasport(passport)).stream()
                .filter(x -> x.getRequisites().equals(account.getRequisites()))
                .collect(Collectors.toList()).size();
        if (count == 0) {
            this.bank.get(getUserByPasport(passport)).add(account);
        }
    }

    /**
     * Удалить один счёт пользователя
     *
     * @param passport - номер паспорта
     * @param account  - объект "Счет"
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = getUserByPasport(passport);
        if (user != null) {
            this.bank.get(getUserByPasport(passport)).remove(account);
        }
    }

    /**
     * Получить счет по пользователю и реквизиту
     *
     * @param user      - объект "Пользователь"
     * @param requisite - номер счета
     * @return - объект "Счет"
     */
    public Account getAccountByRequisite(User user, String requisite) {
        return this.bank.get(user).stream()
                .filter(x -> x.getRequisites().equals(requisite))
                .findAny()
                .orElse(null);
    }

    /**
     * Получить список счетов для пользователя
     *
     * @param passport - номер паспорта
     * @return - список объектов "Счет"
     */
    public List<Account> getUserAccounts(String passport) {
        return this.bank.get(this.bank.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findAny()
                .orElse(null));
    }

    /**
     * Получение счета по номеру паспорта и реквизиту
     *
     * @param passport  - номер паспорта
     * @param requisite - номер счета
     * @return - объект "Счет"
     */
    public Account getAccountByPassportAndRequisite(String passport, String requisite) {
        Account account = null;
        User user = getUserByPasport(passport);
        if (user != null) {
            account = getAccountByRequisite(user, requisite);
        }
        return account;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт
     *
     * @param srcPassport  - номер паспорта отправителя
     * @param srcRequisite - номер счета отправителя
     * @param dstPassport  - номер паспорта получателя
     * @param dstRequisite - номер счета получателя
     * @param amount       - сумма перевода
     * @return - выполнен перевод или нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAccount = getAccountByPassportAndRequisite(srcPassport, srcRequisite);
        Account dstAccount = getAccountByPassportAndRequisite(dstPassport, dstRequisite);
        if ((srcAccount != null) && (dstAccount != null)) {
            if (srcAccount.getValue() >= amount) {
                srcAccount.setValue(srcAccount.getValue() - amount);
                dstAccount.setValue(dstAccount.getValue() + amount);
                result = true;
            }
        }
        return result;
    }
}