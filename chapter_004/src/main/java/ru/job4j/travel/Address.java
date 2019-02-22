package ru.job4j.travel;

import java.util.Objects;

/**
 * Адрес
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Address implements Comparable<Address> {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", home=" + home
                + ", apartment=" + apartment
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else {
            if (o == null || getClass() != o.getClass()) {
                result = false;
            } else {
                Address address = (Address) o;
                result = (home == address.home
                        && apartment == address.apartment
                        && Objects.equals(city, address.city)
                        && Objects.equals(street, address.street));
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public int compareTo(Address adr) {
        return this.city.compareTo(adr.getCity());
    }
}