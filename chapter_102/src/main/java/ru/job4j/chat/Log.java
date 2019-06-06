package ru.job4j.chat;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Write string into log-file
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Log {
    private FileWriter fout;

    public Log(String fileName) {
        try {
            this.fout = new FileWriter(System.getProperty("user.dir") + "\\" + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка открытия файла: " + e);
        }
    }

    public void writeLog(String mess) {
        try {
            this.fout.write(mess + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e);
        }
    }

    public void closeLog() {
        try {
            this.fout.close();
        } catch (IOException e) {
            System.out.println("Ошибка закрытия файла: " + e);
        }
    }
}