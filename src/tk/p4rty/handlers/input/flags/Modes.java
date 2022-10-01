package tk.p4rty.handlers.input.flags;

public enum Modes {
    DEFAULT("", new String[0]),
    //TODO: what the fuck?? graph??? who decided that was a good idea to attempt to add??
    QUADRATIC("QUADRATIC", new String[]{"TURNING_POINT", "ROOT", "Y_INTERCEPT", "TBI: GRAPH"}),
    POLYNOMIAL("POLYNOMIAL", new String[]{"um uhh uhmmmm hmm"}),
    TRIG("TRIG", new String[]{"FIND_ANGLE", "FIND_SIDE"}),
    PARSE("PARSE", new String[]{"EVAL"});

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
