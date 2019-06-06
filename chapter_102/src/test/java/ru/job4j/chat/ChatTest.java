package ru.job4j.chat;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

/**
 * Test write message to the log-file and test get message from the file/
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ChatTest {

    @Test
    public void getPhraseFromFile() {
        String fileName = "test_mess.txt";
        String phr1 = "Phrase1";
        String phr2 = "Phrase2";

        Log myLog = new Log(fileName);
        myLog.writeLog(phr1 + System.lineSeparator());
        myLog.writeLog(phr2);
        myLog.closeLog();

        Message myPhrase = new Message(fileName);
        String result = myPhrase.getPhrase();
        assertTrue(result.equals(phr1) || result.equals(phr2));
    }
}