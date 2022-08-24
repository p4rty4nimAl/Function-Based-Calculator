package tk.p4rty.handlers.output.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void writeToFile(File file, String output) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(output);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
