package ru.job4j.chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Get text string from the file
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Message {
    private List<String> phrases;

    public Message(String fileName) {
        try {
            BufferedReader fin = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "\\" + fileName)));
            String line = null;
            phrases = new ArrayList<>();
            while ((line = fin.readLine()) != null) {
                phrases.add(line);
            }
            fin.close();
        } catch (IOException e) {
            System.out.println("Ошибка открытия файла: " + e);
        }
    }

    public String getPhrase() {
        return phrases.get((int) (Math.random() * (phrases.size() - 1)));
    }
}