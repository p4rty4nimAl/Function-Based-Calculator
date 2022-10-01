package tk.p4rty.handlers.input;

import tk.p4rty.Util;

public enum Flags {
    HELP("--help", new String[]{"-h", "--h"}, "Prints this help page. If another flag is specified after this one, it will be highlighted in the page."),
    INPUT("--input", new String[]{"-i, --i"}, "Allows specification of the variables to be used in calculation."),
    OUTPUT("--output", new String[]{"-o", "--o"}, "Select where the output will be displayed. <console | file>"),
    FILE("--output-file", new String[]{"-of", "--of"}, "Defines the output file for the calculator. Defaults to \"output.txt\" in the current directory."),
    CLEAR("--clear-file", new String[]{"-cf", "--cf"}, "Clears the output file when set to true, before printing the current runs' output."),
    MODE("--mode", new String[]{"-m", "--m"}, "Sets the mode."),
    FUNCTION("--function", new String[]{"-f", "--f"}, "Picks a function from the desired mode."),
    BOOKCODE("--bookcode", new String[]{"-bc", "--bc"}, "Defines a bookwork code to assign to the answer"),
    BOOKCODEFILE("--bookcodefile", new String[]{"-bcf", "--bcf"}, "Defines a file to output bookwork codes with their answers to. Saved to disk inside the config file."),

    DEBUG("--debug", new String[]{"-d", "--d"}, "Enables the debug mode when set to true.");

    private final String flag;
    private final String[] aliases;
    public final String quickDef;
    private String value;

    Flags(String flag, String[] aliases, String quickDef) {
        this.flag = flag;
        this.aliases = aliases;
        this.quickDef = quickDef;
    }

    public static String resolveAlias(String alias) {
        for (int i = 0; i < Flags.values().length; i++) {
            if (alias.equals(Flags.values()[i].flag)) return alias;
            for (int j = 0; j < Flags.values()[i].aliases.length; j++) {
                if (alias.equals(Flags.values()[i].aliases[j])) return Flags.values()[i].flag;
            }
        }
        return null;
    }
    public static String[][][] getInfo() {
        String[][] flags = new String[1][Flags.values().length];
        String[][] aliases = new String[Flags.values().length][];
        String[][] quickDefs = new String[1][Flags.values().length];
        for (int i = 0; i < Flags.values().length; i++) {
            flags[0][i] = Flags.values()[i].flag;
        }
        for (int i = 0; i < Flags.values().length; i++) {
            aliases[i] = Flags.values()[i].aliases;
        }
        for (int i = 0; i < Flags.values().length; i++) {
            quickDefs[0][i] = Flags.values()[i].quickDef;
        }
        return new String[][][]{flags, aliases, quickDefs};
    }
    public String getFlag() {
        return flag;
    }
    public String getValue() {
        return value;
    }
    private void setValue(String value) {
        this.value = value;
    }

    public static void assignValues(String[][] values) {
        for (Flags flag : Flags.values()) {
            flag.setValue(values[Util.searchArray(Handler.flags, flag.flag)][1]);
        }
    }

    public static void setDefaultsForNulls() {
        if (FILE.getValue() == null) {
            FILE.setValue("output.txt");
        }
        if (BOOKCODEFILE.getValue() == null) {
            //TODO: need to check conf here too
            BOOKCODEFILE.setValue("bookcodes.txt");
        }
    }
}
