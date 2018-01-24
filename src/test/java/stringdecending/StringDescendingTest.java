package stringdecending;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static stringdecending.StringDescending.stringDescending;

public class StringDescendingTest {

    String[][] testcases =
    /*  Description                     Input and Expected Result */
    {{  "single word",                  "interview",
                                        "wvtrniiee"
    },{ "lower case asc order",         "abcdefghijklmnopqrstuvwxyz",
                                        "zyxwvutsrqponmlkjihgfedcba"
    },{ "lower case desc order",        "zyxwvutsrqponmlkjihgfedcba",
                                        "zyxwvutsrqponmlkjihgfedcba"
    },{ "lower case random order",      "thequickbrownfoxjumpsoverthelazydog",
                                        "zyxwvuuttsrrqpoooonmlkjihhgfeeedcba"
    },{ "contains upper case letter",   "abCdefg",
                                        "IllegalArgumentException"
    },{ "contains punctuation",         "good-day",
                                        "IllegalArgumentException"
    },{ "space at start",               " edcba",
                                        "IllegalArgumentException"
    },{ "space in middle",              "ab cd",
                                        "IllegalArgumentException"
    },{ "space at end",                 "abcd ",
                                        "IllegalArgumentException"
    },{ "non english character",        "paßß",
                                        "IllegalArgumentException"
    },{ "string size 0",                "",
                                        "IllegalArgumentException"
    },{ "string size 1",                "a",
                                        "a"
    },{ "string size 2",                "ba",
                                        "ba"
    },{ "string size 3",                "abc",
                                        "cba"
    },{ "string size 50",               "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij",
                                        "jjjjjiiiiihhhhhgggggfffffeeeeedddddcccccbbbbbaaaaa",
    },{ "string size 51",               "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijk",
                                        "IllegalArgumentException"
    },{ "string size 1,000",            "<abcdefghijabcdefghijabcdefghi></abcdefghijabcdefghijabcdefghi>jabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij",
                                        "IllegalArgumentException"
    }};

    @Test
    public void testcases() throws Exception {

        for (int i = 0; i < testcases.length; i++){
            System.out.println(testcases[i][0]);

            if (testcases[i][2].equals("IllegalArgumentException")) {
                boolean problem = true;
                try {
                    stringDescending(testcases[i][1]);
                    problem = true;
                } catch (Exception e) {
                    problem = false;
                } finally {
                    if (problem) {
                        System.out.println(problem);
                        Assert.fail();
                    }
                }
            } else {
                Assert.assertEquals(stringDescending(testcases[i][1]), testcases[i][2]);
            }
        }
    }
}
