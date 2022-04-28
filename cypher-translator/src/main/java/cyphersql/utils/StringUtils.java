package cyphersql.utils;

public class StringUtils {
    public static String removeQuotes(String text) {
        return text.replaceAll("(?<!\\\\)\"|(?<!\\\\)`|(?<!\\\\)'", "");
    }

    public static boolean isInt(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
