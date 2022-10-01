package tk.p4rty.handlers.output.file;

import tk.p4rty.handlers.input.Flags;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static tk.p4rty.Main.OUTPUTFILE;

public class Setup {
    public static void setupFile() {
        OUTPUTFILE = new File(Flags.FILE.getValue() != null ? Flags.FILE.getValue() : "output.txt");
        try {
            if (OUTPUTFILE.createNewFile()) {
                System.out.println("Output file did not exist; created at: " + OUTPUTFILE.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Objects.equals(Flags.CLEAR.getValue(), "true")) {
            Write.clearFile(OUTPUTFILE);
        }
    }
}
