package util;

public class Util {
    public static String toTitleCase(String strIn) {
        String[] words = strIn.split(" ");
        String titleCase = "";

        for (String word : words) {
            titleCase += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }

        return titleCase;
    }
}