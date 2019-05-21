package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test search file in the directory
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class SearchTest {
    private String parent = System.getProperty("java.io.tmpdir") + "job4j";

    @Test
    public void testSearch() {
        try {
            File file = new File(parent, "temp.txt");
            if (file.createNewFile()) {
                System.out.println("New file temp.txt is created!");
            } else {
                System.out.println("temp.txt already exists.");
            }

            File file1 = new File(parent, "temp1.lst");
            if (file1.createNewFile()) {
                System.out.println("New file temp1.lst is created!");
            } else {
                System.out.println("temp1.lst already exists.");
            }

            File file2 = new File(parent, "temp2.log");
            if (file2.createNewFile()) {
                System.out.println("New file temp2.log is created!");
            } else {
                System.out.println("temp2.log already exists.");
            }
            List<File> files = new ArrayList<>();
            files.add(file);
            files.add(file2);

            List<String> exts = Arrays.asList("txt", "log");
            Search my = new Search();
            List<File> result = my.files(parent, exts);
            assertThat(result, is(files));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
