package problem_402;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void removeKdigits1() {
        String number = "1432219";
        int k = 3;
        Solution solution = new Solution();
        String answer = solution.removeKdigits(number, k);
        Assert.assertEquals("1219", answer);
    }

    @Test
    public void removeKdigits2() {
        String number = "10200";
        int k = 1;
        Solution solution = new Solution();
        String answer = solution.removeKdigits(number, k);
        Assert.assertEquals("200", answer);
    }

    @Test
    public void removeKdigits3() {
        String number = "9";
        int k = 1;
        Solution solution = new Solution();
        String answer = solution.removeKdigits(number, k);
        Assert.assertEquals("0", answer);
    }

    @Test
    public void removeKdigits4() {
        String number = "43214321";
        int k = 4;
        Solution solution = new Solution();
        String answer = solution.removeKdigits(number, k);
        Assert.assertEquals("1321", answer);
    }
}