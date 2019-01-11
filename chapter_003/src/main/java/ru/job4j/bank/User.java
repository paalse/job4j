package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывающий пользователя
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class User implements Comparable<User> {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = true;
        User other = (User) obj;
        if ((obj == null)
                || (getClass() != obj.getClass())
                || (!this.name.equals(other.name))
                || (!this.passport.equals(other.passport))) {
            result = false;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public int compareTo(User o) {
        final int result = this.getName().compareTo(o.getName());
        return result != 0 ? result : this.getPassport().compareTo(o.getPassport());
    }
}