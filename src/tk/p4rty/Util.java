package tk.p4rty;

import tk.p4rty.handlers.input.Flags;

import java.util.Arrays;
import java.util.Objects;

import static tk.p4rty.Main.OUTPUTFILE;
import static tk.p4rty.handlers.output.file.Write.writeToFile;

public class Util {
    public static String padString(String string, int padding, char paddingChar) {
        if (string.length() >= padding) return string;
        char[] paddedChars = new char[padding];
        Arrays.fill(paddedChars, string.length(), paddedChars.length, paddingChar);
        System.arraycopy(string.toCharArray(), 0, paddedChars, 0, string.length());
        return new String(paddedChars);
    }
    public static String padString(String string, int padding) {
        return padString(string, padding, ' ');
    }
    public static void printOut(String output) {
        if (Objects.equals(Flags.OUTPUT.getValue(), "file")) {
            writeToFile(OUTPUTFILE, output);
        } else System.out.println(output);
    }
    public static <T> int searchArray(T[] array, T search) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == search) return i;
        }
        return -1;
    }
    public static boolean isDebugMode() {
        return Objects.equals(Flags.DEBUG.getValue(), "true");
    }
}
