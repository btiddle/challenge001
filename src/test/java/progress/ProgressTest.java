package progress;

import org.testng.Assert;
import org.testng.annotations.*;

import static progress.Progress.percentDone;

public class ProgressTest {

    String[][] letters = {
            {"!\"\"\"\"\"\"\"\"\"", "10"},
            {"##$$$$$$$$", "20"},
            {"%%%&&&&&&&", "30"},
            {"''''((((((", "40"},
            {")))))*****", "50"},
            {"++++++,,,,", "60"},
            {"-------...", "70"},
            {"////////00", "80"},
            {"1111111112", "90"},
            {"3444444444", "10"},
            {"5566666666", "20"},
            {"7778888888", "30"},
            {"9999::::::", "40"},
            {";;;;;<<<<<", "50"},
            {"======>>>>", "60"},
            {"???????@@@", "70"},
            {"AAAAAAAABB", "80"},
            {"CCCCCCCCCD", "90"},
            {"EFFFFFFFFF", "10"},
            {"GGHHHHHHHH", "20"},
            {"IIIJJJJJJJ", "30"},
            {"KKKKLLLLLL", "40"},
            {"MMMMMNNNNN", "50"},
            {"OOOOOOPPPP", "60"},
            {"QQQQQQQRRR", "70"},
            {"SSSSSSSSTT", "80"},
            {"UUUUUUUUUV", "90"},
            {"WXXXXXXXXX", "10"},
            {"YYZZZZZZZZ", "20"},
            {"[[[\\\\\\\\\\\\\\", "30"},
            {"]]]]^^^^^^", "40"},
            {"_____`````", "50"},
            {"aaaaaabbbb", "60"},
            {"cccccccddd", "70"},
            {"eeeeeeeeff", "80"},
            {"gggggggggh", "90"},
            {"ijjjjjjjjj", "10"},
            {"kkllllllll", "20"},
            {"mmmnnnnnnn", "30"},
            {"oooopppppp", "40"},
            {"qqqqqrrrrr", "50"},
            {"sssssstttt", "60"},
            {"uuuuuuuvvv", "70"},
            {"wwwwwwwwxx", "80"},
            {"yyyyyyyyyz", "90"},
            {"{|||||||||", "10"},
            {"}}~~~~~~~~", "20"}
    };

    String[][] percents = {
            {"133",     "33"},
            {"223",     "66"},
            {"166666",  "16"},
            {"226666",  "33"},
            {"333666",  "50"},
            {"444466",  "66"},
            {"555556",  "83"},
            {"1777777", "14"},
            {"2277777", "28"},
            {"3337777", "42"},
            {"4444777", "57"},
            {"5555577", "71"},
            {"6666667", "85"},
    };

    @Test
    public void all_letters_and_percents_10_to_90_by_10() throws Exception {
        for (int i = 0; i < letters.length; i++) {
            System.out.println(letters[i][0]);
            Assert.assertEquals(percentDone(letters[i][0]), (int) Integer.valueOf(letters[i][1]));
        }
    }

    @Test
    public void all_non_div_by_10_percents() throws Exception {
        for (int i = 0; i < percents.length; i++) {
            System.out.println(percents[i][0]);
            Assert.assertEquals(percentDone(percents[i][0]), (int) Integer.valueOf(percents[i][1]));
        }
    }

    @Test
    public void X_X_dash_dash() throws Exception {
        Assert.assertEquals(percentDone("XX--"), 50);
    }

    @Test
    public void zero_dot_dot_dot_dot_dot() throws Exception {
        Assert.assertEquals(percentDone("0....."), 16);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void only_one_character_represetned() throws Exception {
        Assert.assertEquals(percentDone(".........."), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_size_zero() throws Exception {
        Assert.assertEquals(percentDone(""), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_size_one() throws Exception {
        Assert.assertEquals(percentDone("W"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_size_11() throws Exception {
        Assert.assertEquals(percentDone("1234567890Q"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_contains_3_characters() throws Exception {
        Assert.assertEquals(percentDone("123"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_contains_4_characters() throws Exception {
        Assert.assertEquals(percentDone("1234"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_contains_5_characters() throws Exception {
        Assert.assertEquals(percentDone("12345"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_contains_6_characters() throws Exception {
        Assert.assertEquals(percentDone("123456"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_contains_7_characters() throws Exception {
        Assert.assertEquals(percentDone("1234567"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_contains_8_characters() throws Exception {
        Assert.assertEquals(percentDone("12345678"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_contains_9_characters() throws Exception {
        Assert.assertEquals(percentDone("123456789"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_contains_10_characters() throws Exception {
        Assert.assertEquals(percentDone("1234567890"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_is_not_in_format_str1str2() throws Exception {
        Assert.assertEquals(percentDone("ABABABAB"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_has_space_at_start() throws Exception {
        Assert.assertEquals(percentDone(" AAAAAAAAA"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void string_has_space_at_end() throws Exception {
        Assert.assertEquals(percentDone("AAAAAAAAA "), 7);
    }
}
