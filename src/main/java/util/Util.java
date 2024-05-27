package util;

public class Util {
    /**
    * Converts each word in a string to title case.
    *
    * @param strIn the input string
     * @return the string with each word converted to title case
            */
    public static String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        String titleCase = "";
        String word = "";
        boolean isStartOfWord = true;

        for (char c : strIn.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (!word.isEmpty()) {
                    if (isStartOfWord) {
                        titleCase += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ";
                    } else {
                        titleCase += word.toLowerCase() + " ";
                    }
                    word = "";
                    isStartOfWord = true;
                }
            } else {
                word += c;
                isStartOfWord = false;
            }
        }

        // Process the last word if there is any
        if (!word.isEmpty()) {
            if (isStartOfWord) {
                titleCase += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            } else {
                titleCase += word.toLowerCase();
            }
        } else if (titleCase.endsWith(" ")) {
            // Remove the trailing space if it exists
            titleCase = titleCase.substring(0, titleCase.length() - 1);
        }

        return titleCase;
    }
}
