package util;

public class Util {
    public static String toTitleCase(String strIn) {
        if (strIn.isEmpty()) {
            return "";
        }
        String[] words = strIn.split(" ");
        return words[0].substring(0, 1).toUpperCase() + words[0].substring(1).toLowerCase() + " " +
                words[1].substring(0, 1).toUpperCase() + words[1].substring(1).toLowerCase();
    }
}