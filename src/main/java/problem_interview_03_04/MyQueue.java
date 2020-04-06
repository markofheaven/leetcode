package problem_interview_03_04;

import java.util.Stack;

/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * 说明：
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 执行用时 :12 ms, 在所有 Java 提交中击败了86.85%的用户
 * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了100.00%的用户
 * Author: markofheaven
 * Date: 2020-04-06
 */
public class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;

    /** Initialize your data structure here. */
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!second.isEmpty()) {
            Integer secondValue = second.pop();
            first.push(secondValue);
        }
        first.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!first.isEmpty()) {
            Integer firstValue = first.pop();
            second.push(firstValue);
        }
        return second.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!first.isEmpty()) {
            Integer firstValue = first.pop();
            second.push(firstValue);
        }
        return second.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (first.isEmpty() && second.isEmpty());
    }
}
