package tk.p4rty;

import tk.p4rty.handlers.input.Flags;
import tk.p4rty.handlers.input.Handler;

import java.io.File;
import java.io.IOException;

import static tk.p4rty.Constants.CONFIG_FILE;

public class Main { //TODO: push to github(?)
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
        OUTPUTFILE = new File(Flags.FILE.getValue() != null ? Flags.FILE.getValue() : "output.txt");
        try {
            if (OUTPUTFILE.createNewFile()) {
                System.out.println("Output file did not exist; created at: " + OUTPUTFILE.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ("true".equals(Flags.DEBUG.getValue())) {
            for (Flags flag : Flags.values()) {
                if (flag.getValue() != null) System.out.println(flag.getFlag() + " " + flag.getValue());
            }
        }
    }
}
