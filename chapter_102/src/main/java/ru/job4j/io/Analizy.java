package ru.job4j.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Обработка log-файла, с записью результата в другой файл
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Analizy {
    public void unavailable(String source, String target) {

        try {
            BufferedReader buffIn = new BufferedReader(new FileReader(source));
            BufferedWriter buffOut = new BufferedWriter(new FileWriter(target));

            String line;
            String[] linePrevious = {"", ""};
            String[] lineCurrent = {"", ""};
            String startTime = "";
            String endTime = "";
            String lineSeparator = System.lineSeparator();

            while ((line = buffIn.readLine()) != null) {
                lineCurrent = line.split(" ");

                if ((lineCurrent[0].equals("400") || lineCurrent[0].equals("500"))
                        && ((linePrevious[0].equals("200") || linePrevious[0].equals("300"))
                        || (linePrevious[0].equals("")))) {
                    startTime = lineCurrent[1];
                } else if ((lineCurrent[0].equals("200") || lineCurrent[0].equals("300"))
                        && (linePrevious[0].equals("400") || linePrevious[0].equals("500"))) {
                    endTime = lineCurrent[1];
                }

                linePrevious = lineCurrent;

                if (!startTime.equals("") && !endTime.equals("")) {
                    buffOut.write(startTime + ";" + endTime + lineSeparator);
                    startTime = "";
                    endTime = "";
                }
            }
            buffOut.close();
            buffIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}