package ru.job4j.travel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Обработка профиля клиента
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(x -> x.getAddress())
                .collect(Collectors.toList());
    }
}