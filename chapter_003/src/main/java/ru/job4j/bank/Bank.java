package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

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
        User result = null;
        Set<User> users = this.bank.keySet();
        //  if (users.size()!=0) {
        for (User user : users) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Добавить счёт пользователю
     *
     * @param passport - номер паспорта
     * @param account  - объект "Счет"
     */
    public void addAccountToUser(String passport, Account account) {
        int count = 0;
        for (Account element : this.bank.get(getUserByPasport(passport))) {
            if (element.getRequisites().equals(account.getRequisites())) {
                count++;
                break;
            }
        }
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
        Account result = null;
        for (Account element : this.bank.get(user)) {
            if (element.getRequisites().equals(requisite)) {
                result = element;
                break;
            }
        }
        return result;
    }

    /**
     * Получить список счетов для пользователя
     *
     * @param passport - номер паспорта
     * @return - список объектов "Счет"
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (User element : this.bank.keySet()) {
            if (element.getPassport().equals(passport)) {
                result = this.bank.get(element);
                break;
            }
        }
        return result;
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