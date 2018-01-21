package reversewords;

/* package whatever; // don't place package name! */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class ReverseWords {

    private static String usage() {
        return (
            "\n" +
            "Usage: ReverseWords num_lines[\\nline]+\n" +
            "Options: \n" +
            " num_lines    Is the number of lines of input that follows.\n" +
            "              1 <= num_lines <= 100. \n" +
            " \\n           Is a new line.\n" +
            " line         Contains one or several words separated with single spaces.\n" +
            "              Each word is a sequence of letters of English alphabet.\n" +
            "              Each word contains between 1 and 10 characters.\n" +
            "              Total number of words in the input is between 1 and 100.\n" +
            "Output:\n" +
            " Reverse each word in each line of input, while preserving the order of\n" +
            " words in each line. The lines of your output should not have any trailing\n" +
            " or leading spaces."
        );
    }

    private static boolean stringIsEmpty(String line) {
        return (line == null || line.isEmpty());
    }

    private static int calculateNumLLines(String line) {
        int numLines;
        try {
            numLines = Integer.parseInt(line);
            if (numLines < 1 || numLines > 100)
                return 0;
        } catch (NumberFormatException e) {
            return 0;
        }
        return numLines;
    }

    private static List<String> getLines() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (stringIsEmpty(line))
            throw new IllegalArgumentException("ERROR: Value for num_lines is missing.");

        int numLines = calculateNumLLines(line);
        if (numLines == 0)
            throw new IllegalArgumentException("ERROR: num_lines value is invalid. ");

        List<String> lines = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();

        if (numLines != lines.size())
            throw new IllegalArgumentException("ERROR: num_lines does not match actual number of lines.");

        return lines;
    }

    private static int printLine(String sentence, int lineNum) throws Exception {
        StringBuilder reverseSentence = new StringBuilder();

        if (stringIsEmpty(sentence))
            throw new IllegalArgumentException("ERROR: Line " + (lineNum + 1) + " is empty.");

        char lastChar = sentence.charAt(sentence.length() - 1);
        if (lastChar == ' ')
            throw new IllegalArgumentException("ERROR: Line " + (lineNum + 1) + " has trailing space.");

        String[] words = sentence.split(" ");

        for (int wordNum = 0; wordNum < words.length; wordNum++) {
            String word = words[wordNum];
            if (stringIsEmpty(word))
                throw new IllegalArgumentException("ERROR: Line " + (lineNum + 1) + " word " + (wordNum + 1) + " has extra space.");

            if(!Pattern.matches("[a-zA-Z]+", word))
                throw new IllegalArgumentException("ERROR: Line " + (lineNum + 1) + " word " + (wordNum + 1) + " has letter not in English alphabet.");

            if (word.length() > 10)
                throw new IllegalArgumentException("ERROR: Line " + (lineNum + 1) + " word " + (wordNum + 1) + " has length greater than 10.");

            String reverseWord = new StringBuilder(word).reverse().toString();
            if (wordNum > 0)reverseSentence.append(" ");
            reverseSentence.append(reverseWord);
        }
        reverseSentence.append("\n");
        System.out.print(reverseSentence);
        return words.length;
    }

    public static void main(String[] args) throws java.lang.Exception {
        List<String> lines = new ArrayList<>();
        int totalWords = 0;

        try {
            lines = getLines();
            for (int num = 0; num < lines.size(); num++) {
                String line = lines.get(num);
                totalWords += printLine(line, num);
                if (totalWords > 100)
                    throw new IllegalArgumentException("ERROR: Line " + (num + 1) + " total number of words exceed 100.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(usage());
        }
    }
}
