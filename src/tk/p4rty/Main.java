package tk.p4rty;

import tk.p4rty.handlers.input.Flags;
import tk.p4rty.handlers.input.Handler;
import tk.p4rty.handlers.output.file.Setup;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static tk.p4rty.Constants.CONFIG_FILE;
import static tk.p4rty.Util.isDebugMode;

public class Main {
    public static File OUTPUTFILE;

    public static void main(String[] args) {
        try {
            if (CONFIG_FILE.createNewFile()) {
                System.out.println("Config file not found; created one at: " + CONFIG_FILE.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (args.length == 0) {
            System.out.println("Program run with no arguments. Run with \"--help\" for a list.");
            return;
        }
        Handler.argsAssignmentHandler(args);
        //cannot do printOut(String output) before the following; causes NullPointerException
        Setup.setupFile();
        Util.printOut(new Date().toString());
        if (isDebugMode()) {
            for (Flags flag : Flags.values()) {
                if (flag.getValue() != null) Util.printOut(flag.getFlag() + " " + flag.getValue());
            }
        }
    }
}
