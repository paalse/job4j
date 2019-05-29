package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Search files and pack into zip-archive
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Zip {
    /**
     * Get a file extension
     *
     * @param pathname File path
     * @return File extension
     */
    public String getExtension(File pathname) {
        String filename = pathname.getName();
        int i = filename.lastIndexOf('.');
        if (i > 0 && i < filename.length() - 1) {
            return filename.substring(i + 1).toLowerCase();
        }
        return "";
    }

    /**
     * Get list of file from path "root" and exclude file with extensions "ext"
     *
     * @param root path
     * @param ext  exclude extensions
     * @return list of files
     */
    List<File> seekBy(String root, List<String> ext) {
        List<File> result = new ArrayList<>();
        File dir = new File(root);
        for (File item : Objects.requireNonNull(dir.listFiles())) {
            if (item.isDirectory()) {
                for (File item1 : seekBy(item.getPath(), ext)) {
                    if (ext.indexOf(getExtension(item)) == -1) {
                        result.add(item1);
                    }
                }
                continue;
            }
            if (ext.indexOf(getExtension(item)) == -1) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Pack files into zip-archive
     *
     * @param sources - list of files
     * @param target  - archive name
     */
    void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {

            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Args argument = new Args(args);
        Zip myZip = new Zip();
        List<File> files = myZip.seekBy(argument.directory(), argument.exclude());
        myZip.pack(files, new File(argument.output()));
    }
}