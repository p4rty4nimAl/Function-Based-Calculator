package tk.p4rty.handlers.input.flags;

public enum Modes {
    DEFAULT("", new String[0]),
    GRAPH("GRAPH", new String[]{"TURNING_POINT", "ROOT", "Y_INTERCEPT"}),
    TRIG("TRIG", new String[]{"FIND_ANGLE", "FIND_SIDE"});

    private final String string;
    public final String[] functions;

    Modes(String string, String[] functions) {
        this.string = string;
        this.functions = functions;
    }

    public static Modes getMode(String mode) {
        for (Modes m : Modes.values()) {
            if (m.string.equals(mode)) return m;
        }
        return DEFAULT;
    }
}
