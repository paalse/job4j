package ru.job4j.chat;

import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Programm "Console chat"
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Chat {
    Log log = new Log("chat.log");
    Message mess = new Message("phrases.txt");
    String inLine;
    String outLine;
    boolean answerFlag = true;
    boolean exitFlag = false;

    public void startChat() {
        do {
            Scanner in = new Scanner(System.in, Charset.forName("Windows-1251"));
            inLine = in.nextLine().toLowerCase();
            log.writeLog(inLine);

            if (inLine.equals("завершить")) {
                exitFlag = true;
            } else if (inLine.equals("стоп")) {
                answerFlag = false;
            } else if (inLine.equals("продолжить")) {
                answerFlag = true;
            }

            if (answerFlag && !exitFlag) {
                outLine = mess.getPhrase();
                log.writeLog(outLine);
                System.out.println(outLine);
            }
        } while (!exitFlag);
        log.closeLog();
    }

    public static void main(String[] args) {
        new Chat().startChat();
    }
}