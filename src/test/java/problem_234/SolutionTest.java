package problem_234;

import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isPalindrome() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Solution solution = new Solution();
        boolean result = solution.isPalindrome(head);
        Assert.assertEquals(false, result);
    }
}