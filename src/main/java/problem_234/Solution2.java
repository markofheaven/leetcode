package problem_234;

/**
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.84%的用户
 * 内存消耗 :42.4 MB, 在所有 Java 提交中击败了9.23%的用户
 * 这就很奇怪了，明明是O(1)的空间复杂度，凭什么我消耗了这么多？？？难道是因为我多写了一个函数？
 *
 * 将翻转函数和主函数合并
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.84%的用户
 * 内存消耗 :42.1 MB, 在所有 Java 提交中击败了14.57%的用户
 * 额，内存消耗减少了，但这有啥用？
 * 又试了几次，看起来执行用时和内存消耗还会受到服务器本身的影响，算了算了，就这样吧
 * Author: markofheaven
 * Date: 2020-04-06
 */

public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }

        ListNode slowPoint = head;
        ListNode quickPoint = head.next;

        ListNode firstHalfListHead;
        ListNode secondHalfListHead;
        while (true) {
            if (quickPoint.next == null) {
                firstHalfListHead = slowPoint;
                secondHalfListHead = slowPoint.next;
                break;
            }
            quickPoint = quickPoint.next;
            if (quickPoint.next == null) {
                firstHalfListHead = slowPoint;
                secondHalfListHead = slowPoint.next.next;
                break;
            }
            quickPoint = quickPoint.next;
            slowPoint = slowPoint.next;
        }

        // 前半段链表翻转
        boolean convertFinish = false;
        if (head == firstHalfListHead) {
            head.next = null;
            convertFinish = true;
        }

        if (!convertFinish && head.next == firstHalfListHead) {
            head.next = null;
            firstHalfListHead.next = head;
            convertFinish = true;
        }

        if (!convertFinish) {
            ListNode current = head.next;
            head.next = null;
            ListNode before = head;
            while (current.next != firstHalfListHead) {
                ListNode temp = current.next;
                current.next = before;
                before = current;
                current = temp;
            }
            current.next = before;
            firstHalfListHead.next = current;
        }

        // 开始比较
        ListNode firstListNode = firstHalfListHead;
        ListNode secondListNode = secondHalfListHead;
        while (firstListNode != null && secondListNode != null) {
            if (firstListNode.val != secondListNode.val) {
                return false;
            }
            firstListNode = firstListNode.next;
            secondListNode = secondListNode.next;
        }
        return true;
    }
}
