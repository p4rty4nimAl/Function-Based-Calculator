package tk.p4rty.handlers.output.text;

import tk.p4rty.handlers.input.Flags;

import java.util.Arrays;

import static tk.p4rty.Util.padString;

public class Text {
    public static void printHelp(String match) {
        String[][][] info = Flags.getInfo();
        int flagHeaderWidth = -1;
        int aliasesHeaderWidth = -1;
        for (int i = 0; i < info[0][0].length; i++) {
            if (info[0][0][i].length() > flagHeaderWidth) flagHeaderWidth = info[0][0][i].length();
            if (Arrays.toString(info[1][i]).length() - 2 > aliasesHeaderWidth) aliasesHeaderWidth = Arrays.toString(info[1][i]).length() - 2;
        }
        // The following statement makes the first line of the "--help" result.
        System.out.println(padString("Flag    ", flagHeaderWidth + 4) +
                padString("Aliases    ", aliasesHeaderWidth + 4) +
                "Description");
        for (int i = 0; i < info[0][0].length; i++) {
            int cutoff = 0;
            int lastCutoff = 0;
            String aliases = Arrays.toString(info[1][i]).substring(1, Arrays.toString(info[1][i]).length() - 1);

            System.out.print(
                    (info[0][0][i].equals(match) ? "> " : "") +
                    padString(info[0][0][i], flagHeaderWidth + 4) +
                    padString(aliases, Math.max(aliasesHeaderWidth + 4, "Aliases    ".length()))
            );
            for (int j = 0; j * 80 < info[2][0][i].length(); j++) {
                if (j == 0) lastCutoff = 0; else lastCutoff = cutoff + 1;
                cutoff = info[2][0][i].substring(j * 80, Math.min((j + 1) * 80, info[2][0][i].length())).lastIndexOf(' ');
                System.out.print(
                        info[0][0][i].equals(match) && j > 0 ? "> " : "" +
                                (info[2][0][i].length() < 80 ? info[2][0][i] + "\n" :
                                        (
                                            j > 0 ? (
                                                    padString("", flagHeaderWidth + 4) +
                                                    padString("", Math.max(aliasesHeaderWidth + 4, "Aliases    ".length()))
                                            ) : ""
                                    ) + (
                                        j == 0 ?
                                                (info[2][0][i].substring(0, Math.min(cutoff, info[2][0][i].length())) + "\n") :
                                                info[2][0][i].substring(lastCutoff, Math.max((cutoff + (j * 80)), info[2][0][i].length())) + "\n"
                                        )
                                )
                );
            }
        }
    }
}

