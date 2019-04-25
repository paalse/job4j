package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import static org.junit.Assert.assertEquals;

/**
 * Проверка обработки log-файла, с записью результата в другой файл
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class AnalizyTest {
    @Test
    public void ioTest() {
        String lineSeparator = System.lineSeparator();
        String sourceFile = "source1.txt";
        String targetFile = "target1.txt";

        try (BufferedWriter buffOut = new BufferedWriter(new FileWriter(sourceFile))) {
            buffOut.write("200 10:56:01" + lineSeparator);
            buffOut.write("500 10:57:01" + lineSeparator);
            buffOut.write("400 10:58:01" + lineSeparator);
            buffOut.write("200 10:59:01" + lineSeparator);
            buffOut.write("500 11:01:02" + lineSeparator);
            buffOut.write("200 11:02:02" + lineSeparator);
            buffOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Analizy().unavailable(sourceFile, targetFile);

        try (BufferedReader buffIn = new BufferedReader(new FileReader(targetFile))) {
            assertEquals("10:57:01;10:59:01", buffIn.readLine());
            assertEquals("11:01:02;11:02:02", buffIn.readLine());
            buffIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}