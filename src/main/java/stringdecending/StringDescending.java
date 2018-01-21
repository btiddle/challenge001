package stringdecending;

/* package whatever; // don't place package name! */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class StringDescending {

    private String string;

    private String usage = "Usage: StringDescending str, where " +
        "str is a single string, " +
        "size 1 to 100, " +
        "of lower-case letter of English alphabet.";

    private void getInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input == null || input.isEmpty() || input.length() > 100)
            throw new IllegalArgumentException();

        for (int i = 0; i < input.length(); i++) {
            if (('a' <= input.charAt(i)) && (input.charAt(i) <= 'z')) {
                // Each is a lower case English alphabet.
            } else {
                throw new IllegalArgumentException();
            }
        }
        string = input;
    }

    public static void main(String[] args) throws java.lang.Exception {
        StringDescending data = new StringDescending();

        try {
            data.getInput();
        } catch (Exception e) {
            throw new IllegalArgumentException(data.usage);
        }

        // Convert String to ArrayList
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(data.string.split("")));

        // Sort ArrayList then reverse it
        Collections.sort(myList, Collections.reverseOrder());

        // Convert ArrayList to String
        data.string = String.join("", myList);

        System.out.println(data.string);
    }
}