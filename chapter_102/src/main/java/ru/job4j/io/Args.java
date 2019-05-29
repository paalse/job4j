package ru.job4j.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Keep arguments receive from command line
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Args {
    private String sourceDir;
    private List<String> excludeExt = new ArrayList();
    private String outFile;

    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-d":
                    sourceDir = args[i + 1];
                    i++;
                    break;
                case "-e":
                    excludeExt = Arrays.asList(args[i + 1].split(","));
                    i++;
                    break;
                case "-o":
                    outFile = args[i + 1];
                    i++;
                    break;
                default:
                    System.out.println("Argument \"" + args[i] + "\" is not correct");
            }
        }
    }

    public String directory() {
        return this.sourceDir;
    }

    public List<String> exclude() {
        return this.excludeExt;
    }
    public String output() {
        return this.outFile;
    }
}