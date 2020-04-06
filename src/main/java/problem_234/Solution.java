package problem_234;

/**
 * 请判断一个链表是否为回文链表。
 * 链表翻转之后，逐个比较即可。
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 使用快慢指针，找到链表中间点。翻转前半段链表，再和后半段逐个比较即可。
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.84%的用户
 * 内存消耗 :42.4 MB, 在所有 Java 提交中击败了9.23%的用户
 * 这就很奇怪了，明明是O(1)的空间复杂度，凭什么我消耗了这么多？？？难道是因为我多写了一个函数？
 * Author: markofheaven
 * Date: 2020-04-06
 */

public class Solution {
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
        convertList(head, firstHalfListHead);

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

    private void convertList(ListNode head, ListNode tail) {
        if (head == tail) {
            head.next = null;
            return;
        }

        if (head.next == tail) {
            head.next = null;
            tail.next = head;
            return;
        }

        ListNode current = head.next;
        head.next = null;
        ListNode before = head;
        while (current.next != tail) {
            ListNode temp = current.next;
            current.next = before;
            before = current;
            current = temp;
        }
        current.next = before;
        tail.next = current;
    }
}
