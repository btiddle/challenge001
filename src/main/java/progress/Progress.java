package progress;

/* package whatever; // don't place package name! */

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class Progress {

    private int percentage;

    private String usage =
        "\n" +
                "usage: Progress str1str2\n" +
        "Options: \n" +
        " str1      A string filled with same one character,\n" +
        "           where length is % complete, 1 <= length <= 9\n" +
        " str2      A string filled with different same one character,\n" +
        "           where length is % left to do, 1 <= length <= 9\n" +
        " ste1ste2  Total size of str1str2 is between 2 and 10 characters,\n" +
        "           and contains no spaces";

    private void getInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input == null || input.isEmpty() || input.length() > 10)
            throw new IllegalArgumentException();

        HashMap<Character, Integer> hm = new HashMap<>();
        int len = input.length();
        int numChars = 1;
        char char1 = input.charAt(0);
        char char2;

        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == ' ')
                throw new IllegalArgumentException();

            if ((i < (len - 1)) && (input.charAt(i) != input.charAt(i + 1))) {
                char2 = input.charAt(i);
                numChars++;
            }

            if (numChars > 2)
                throw new IllegalArgumentException();

            Character key = input.charAt(i);

            if (hm.containsKey(key)) {
                Integer value = hm.get(key);
                hm.put(key, value + 1);
            } else {
                hm.put(key, 1);
            }
        }

        if (hm.size() != 2)
            throw new IllegalArgumentException();

        float value = (float) hm.get(char1) / (float) len;
        percentage = (int) (value * 100.0f);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Progress data = new Progress();

        try {
            data.getInput();
        } catch (Exception e) {
            throw new IllegalArgumentException(data.usage);
        }

        System.out.println(data.percentage);
    }
}
