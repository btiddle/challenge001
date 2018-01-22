package fibonacci;

/* package whatever; // don't place package name! */

import java.io.*;

class FibonacciLike {

    private static String usage() {
        return (
            "\n" +
            "Usage: FibonacciLike a1 a2 n\n" +
            "Options: \n" +
            " a1      The value at the 1st index position of the sequence.\n" +
            " a2      The value at the 2nd index position of the sequence.\n" +
            " n       The n-th index position of the sequence.\n" +
            "Description:\n" +
            " A Fibonacci-like sequence is a sequence of integers\n" +
            " a1, a2, ... for which a[n] = a[n-1] + a[n-2] for all n > 2.\n" +
            " You are given the first two elements of the sequnce a1 and a2,\n" +
            " and the 1-based index n.\n" +
            "Input:\n" +
            " The input data consists of a single line which contains\n" +
            " integers a1, a2 and n separated by single spaces, \n" +
            " where 0 < a1, a2, n < 10.\n" +
            "Output:\n" +
            " The value at the the n-th position of the sequence.\n"
        );
    }

    private static boolean stringIsEmpty(String line) {
        return (line == null || line.isEmpty());
    }

    private static boolean parmsOutOfRange(int a1, int a2, int n) {
        if ((0 < a1 && a1 < 10) && (0 < a2 && a2 < 10) && (2 < n && n < 10)) {
            return false;
        } else {
            return true;
        }
    }

    private static String getInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        return (input);
    }

    public static int fibonacciLike(String input) throws Exception {
        int aNth = 0;

        if (stringIsEmpty(input))
            throw new IllegalArgumentException();

        if (input.trim().length() != input.length())
            throw new IllegalArgumentException();

        String parms[] = input.split(" ");

        if (parms.length != 3)
            throw new IllegalArgumentException();

        int a1 = Integer.parseInt(parms[0]);
        int a2 = Integer.parseInt(parms[1]);
        int n = Integer.parseInt(parms[2]);

        if (parmsOutOfRange(a1, a2, n))
            throw new IllegalArgumentException();

        for (int i = 3; i <= n; i++) {
            aNth = a1 + a2;
            a1 = a2;
            a2 = aNth;
        }

        return aNth;
    }

    public static void main(String[] arg) throws java.lang.IllegalArgumentException {
        try {
            String input = getInput();
            System.out.println(fibonacciLike(input));
        } catch (Exception e) {
            System.out.println("ERROR: Input parameters are not valid.");
            throw new IllegalArgumentException(usage());
        }
    }
}
