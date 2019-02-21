package ru.job4j.travel;

/**
 * Профиль клиента
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Profile {
    private String name;
    private Address address;

    public Profile(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Profile{"
                + "name='" + name + '\''
                + ", address=" + address
                + '}';
    }
}