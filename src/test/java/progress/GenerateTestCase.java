package progress;

import java.util.Collections;

public class GenerateTestCase {

    public static void main(String[] args) {
        for (int i = 33; i <= 126; ) {
            for (int x = 1; x < 10; x++) {

                System.out.print(String.join("", Collections.nCopies(x, String.valueOf( (char)    i))));
                System.out.println(String.join("", Collections.nCopies((10 - x), String.valueOf( (char)   (i + 1)))));


                i = i + 2;
            }
        }
    }
}
