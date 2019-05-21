package ru.job4j.io;

import java.io.File;
import java.util.*;

/**
 * Search file in the directory
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Search {
    /**
     * Get a file extension
     *
     * @param pathname File path
     * @return File extension
     */
    private String getExtension(File pathname) {
        String filename = pathname.getName();
        int i = filename.lastIndexOf('.');
        if (i > 0 && i < filename.length() - 1) {
            return filename.substring(i + 1).toLowerCase();
        }
        return "";
    }

    /**
     * Get a list of files in the directory under the specified extension
     *
     * @param parent Parent directory
     * @param exts   List of extension
     * @return List of file
     */
    List<File> files(String parent, List<String> exts) {
        List<File> result = new LinkedList<>();

        File dir = new File(parent);
        for (File item : Objects.requireNonNull(dir.listFiles())) {
            if (!item.isDirectory()) {
                if (exts.indexOf(getExtension(item)) != -1)
                    result.add(item);
            }
        }
        return result;
    }
}