package problem_interview_09;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 执行用时 :217 ms, 在所有 Java 提交中击败了38.16%的用户
 * 内存消耗 :48 MB, 在所有 Java 提交中击败了100.00%的用户
 * Author: markofheaven
 * Date: 2020-04-06
 */
public class CQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public CQueue() {
        first =  new Stack<>();
        second = new Stack<>();
    }

    public void appendTail(int value) {
        while (!second.isEmpty()) {
            Integer secondValue = second.pop();
            first.push(secondValue);
        }

        first.push(value);
    }

    public int deleteHead() {
        if (first.isEmpty() && second.isEmpty()) {
            return -1;
        }

        while (!first.isEmpty()) {
            Integer firstValue = first.pop();
            second.push(firstValue);
        }

        return second.pop();
    }
}
