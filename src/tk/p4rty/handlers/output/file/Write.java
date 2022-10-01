package tk.p4rty.handlers.output.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void writeToFile(File file, String output) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(output + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void clearFile(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
