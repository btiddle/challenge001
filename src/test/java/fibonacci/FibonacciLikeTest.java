package fibonacci;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import static fibonacci.FibonacciLike.fibonacciLike;

public class FibonacciLikeTest {

    @Test
    public void a1_is_1_a2_is_2_n_is_3() throws Exception {
        assertEquals(fibonacciLike("1 2 3"), 3);
    }

    @Test
    public void a1_is_4_a2_is_2_n_is_3() throws Exception {
        assertEquals(fibonacciLike("4 2 3"), 6);
    }

    @Test
    public void a1_is_4_a2_is_2_n_is_4() throws Exception {
        assertEquals(fibonacciLike("4 2 4"), 8);
    }

    @Test
    public void a1_is_4_a2_is_2_n_is_5() throws Exception {
        assertEquals(fibonacciLike("4 2 5"), 14);
    }

    @Test
    public void a1_is_4_a2_is_2_n_is_6() throws Exception {
        assertEquals(fibonacciLike("4 2 6"), 22);
    }

    @Test
    public void a1_is_4_a2_is_2_n_is_7() throws Exception {
        assertEquals(fibonacciLike("4 2 7"), 36);
    }

    @Test
    public void a1_is_4_a2_is_2_n_is_8() throws Exception {
        assertEquals(fibonacciLike("4 2 8"), 58);
    }

    @Test
    public void a1_is_4_a2_is_2_n_is_9() throws Exception {
        assertEquals(fibonacciLike("4 2 9"), 94);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void n_is_10() throws Exception {
        assertEquals(fibonacciLike("4 2 10"), 153);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void a1_is_0() throws Exception {
        assertEquals(fibonacciLike("0 2 4"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void a1_is_10() throws Exception {
        assertEquals(fibonacciLike("10 2 4"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void a2_is_0() throws Exception {
        assertEquals(fibonacciLike("4 0 4"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void a2_is_10() throws Exception {
        assertEquals(fibonacciLike("4 10 4"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void n_is_0() throws Exception {
        assertEquals(fibonacciLike("0 1 3"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void n_is_1() throws Exception {
        assertEquals(fibonacciLike("1 2 1"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void n_is_2() throws Exception {
        assertEquals(fibonacciLike("1 2 2"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void to_many_parameters() throws Exception {
        assertEquals(fibonacciLike("1 2 2 4"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void not_enough_parameters() throws Exception {
        assertEquals(fibonacciLike("1 2"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void a1_is_not_a_number() throws Exception {
        assertEquals(fibonacciLike("S 1 4"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void a2_is_not_a_number() throws Exception {
        assertEquals(fibonacciLike("4 Z 4"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void n_is_not_a_number() throws Exception {
        assertEquals(fibonacciLike("4 2 R"), 7);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void space_at_front() throws Exception {
        assertEquals(fibonacciLike(" 4 2 4"), 8);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void space_in_middle() throws Exception {
        assertEquals(fibonacciLike("4  2 4 "), 8);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class })
    public void space_at_end() throws Exception {
        assertEquals(fibonacciLike("4 2 4 "), 8);
    }

    @Test
    public void a1_is_04_a2_is_02_n_is_04() throws Exception {
        assertEquals(fibonacciLike("04 02 04"), 8);
    }
}
