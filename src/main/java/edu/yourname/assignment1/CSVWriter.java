package edu.yourname.assignment1;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    public static void writeHeader(String path) throws IOException {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write("algorithm,n,time_ns,depth,comparisons,allocations\n");
        }
    }

    public static void appendLine(String path, String line) throws IOException {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(line + "\n");
        }
    }
}
