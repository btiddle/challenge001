package stringdecending;

/* package whatever; // don't place package name! */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class StringDescending {

    private static String usage =
        "\n" +
        "Usage: StringDescending string\n" +
        "Options: \n" +
        " string   A single string of size 1 to 50 inclusive, where each\n" +
        "          character is a lower-case letter of English alphabet.\n" +
        "Description:\n" +
        " Rearrange characters of this string in non-ascending order and\n" +
        " output the resulting string.";

    private static boolean stringIsEmpty(String line) {
        return (line == null || line.isEmpty());
    }

    private static boolean invalidLetters(String input) {
        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) < 'a' ) || (input.charAt(i) > 'z')) {
                return true;
            }
        }
        return false;
    }

    private static String getInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        return input;
    }

    public static String stringDescending (String input) {

        if (stringIsEmpty(input))
            throw new IllegalArgumentException(
                "ERROR: Input is empty."
            );

        if (input.length() > 50)
            throw new IllegalArgumentException(
                "ERROR: Input length is greater than 50."
            );

        if (invalidLetters(input))
            throw new IllegalArgumentException(
                "Error: String has non lower case English alphabet letters."
            );

        // Convert String to ArrayList
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(input.split("")));

        // Sort ArrayList then reverse it
        Collections.sort(myList, Collections.reverseOrder());

        // Convert ArrayList to String
        input = String.join("", myList);

        return input;
    }

    public static void main(String[] args) throws java.lang.Exception {

        try {
            String input = getInput();
            System.out.println(stringDescending(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(usage);
        }
    }
}