package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test Zip class
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ZipTest {
    @Test
    public void getExtensionTest() {
        Zip zip = new Zip();
        File filename = new File("C:\\projects\\job4j\\my.xml");
        String result = zip.getExtension(filename);
        assertThat(result, is("xml"));
    }

    @Test
    public void seekByTest() {
        String sourceDir = "D:\\TEMP\\job4j\\"; //System.getProperty("java.io.tmpdir") + "job4j";
        try {
            File file = new File(sourceDir, "temp.txt");
            if (file.createNewFile()) {
                System.out.println("New file temp.txt is created!");
            } else {
                System.out.println("temp.txt already exists.");
            }

            File file1 = new File(sourceDir, "temp1.lst");
            if (file1.createNewFile()) {
                System.out.println("New file temp1.lst is created!");
            } else {
                System.out.println("temp1.lst already exists.");
            }

            File file2 = new File(sourceDir, "temp2.log");
            if (file2.createNewFile()) {
                System.out.println("New file temp2.log is created!");
            } else {
                System.out.println("temp2.log already exists.");
            }
            List<File> files = new ArrayList<>();
            files.add(file2);

            List<String> ext = Arrays.asList("lst", "txt");
            Zip zip = new Zip();
            List<File> result = zip.seekBy(sourceDir, ext);
            assertThat(result, is(files));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void packTest() {
        String rootDir = "D:\\TEMP\\";
        String sourceDir = rootDir + "job4j";
        File targetFile = new File(rootDir + "packfile.zip");
        try {
            File file = new File(sourceDir, "temp.txt");
            if (file.createNewFile()) {
                System.out.println("New file temp.txt is created!");
            } else {
                System.out.println("temp.txt already exists.");
            }

            File file1 = new File(sourceDir, "temp1.lst");
            if (file1.createNewFile()) {
                System.out.println("New file temp1.lst is created!");
            } else {
                System.out.println("temp1.lst already exists.");
            }

            File file2 = new File(sourceDir, "temp2.log");
            if (file2.createNewFile()) {
                System.out.println("New file temp2.log is created!");
            } else {
                System.out.println("temp2.log already exists.");
            }

            List<File> files = Arrays.asList(file, file1, file2);
            Zip zip = new Zip();
            zip.pack(files, targetFile);

            assertThat(targetFile.exists(), is(true));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}