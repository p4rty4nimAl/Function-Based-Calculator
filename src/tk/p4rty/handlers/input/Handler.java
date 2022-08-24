package tk.p4rty.handlers.input;

import tk.p4rty.handlers.output.text.Text;

import static tk.p4rty.Util.searchArray;
import static tk.p4rty.handlers.input.Flags.OUTPUT;
import static tk.p4rty.handlers.input.Flags.resolveAlias;

public class Handler {
    public static final String[][] flagValues = new String[Flags.values().length][2];
    public static final String[] flags = new String[Flags.values().length];
    private static boolean verifyArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args.length == i + 1) return false;
            if (args[i].indexOf('-') == 0 && args[i + 1].indexOf('-') != 0) {
                i++;
            } else return false;
        }
        return true;
    }
    public static void argsAssignmentHandler(String[] args) {
        if ("--help".equals(resolveAlias(args[0]))) {
            Text.printHelp(args.length > 1 ? resolveAlias(args[1]) : null);
            return;
        }
        if (!verifyArgs(args)) {
            invalidArgs();
            return;
        }

        for (int i = 0; i < Flags.values().length; i++) {
            flagValues[i][0] = Flags.values()[i].getFlag();
            flags[i] = Flags.values()[i].getFlag();
        }
        for (int i = 1; i < args.length; i += 2) {
            flagValues[searchArray(flags, resolveAlias(args[i - 1]))][1] = args[i];
        }
        Flags.assignValues(flagValues);
        Flags.setDefaultsForNulls();
    }
    public static void invalidArgs() {
        System.out.println("Program run with invalid arguments. Run with \"--help\" for a list of valid arguments.");
    }
}
