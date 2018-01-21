package fibonacci;

/* package whatever; // don't place package name! */

import java.io.*;

class FibonacciLike {

    private int a1, a2, n, an;

    private String usage =
            "Usage: FibonacciLike a1 a2 n, where " +
                    "0 < a1 < 10, " +
                    "0 < a2 < 10 and " +
                    "2 < n < 10";

    private void getInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String parms[] = input.split(" ");

        if (parms.length != 3)
            throw new IllegalArgumentException();

        a1 = Integer.parseInt(parms[0]);
        a2 = Integer.parseInt(parms[1]);
        n = Integer.parseInt(parms[2]);

        if ((0 < a1 && a1 < 10) && (0 < a2 && a2 < 10) && (2 < n && n < 10)) {
            // a1, a2 and n are all within range.
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] arg) throws java.lang.IllegalArgumentException {

        FibonacciLike fib = new FibonacciLike();

        try {
            fib.getInput();
        } catch (Exception e) {
            throw new IllegalArgumentException(fib.usage);
        }

        for (int i = 3; i <= fib.n; i++) {
            fib.an = fib.a1 + fib.a2;
            fib.a1 = fib.a2;
            fib.a2 = fib.an;
        }
        System.out.print(fib.an);
    }
}
