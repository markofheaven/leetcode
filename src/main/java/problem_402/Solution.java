package problem_402;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 执行用时：7ms，超过80.55%
 * 内存消耗：40.1MB，超过5.6%
 * 难道是因为使用了stack所有消耗了这么多内存吗？
 * Author: markofheaven
 * Date: 2020-04-06
 */
public class Solution {
    private Stack<Integer> stack = new Stack<>();
    private int removeNumber = 0;
    private boolean removeEnd = false;

    public String removeKdigits(String num, int k) {
        if (k <= 0) {
            return num;
        }
        if (num.length() <= k) {
            return "0";
        }

        int i = 0;
        for (; i < num.length(); i++) {
            Integer number = getNumber(num, i);
            pushNumber(number, k);
            if (removeEnd) {
                break;
            }
        }

        if (removeNumber < k) {
            removeStack(k);
        }
        return getAnswer(num, i);
    }

    private void pushNumber(Integer number, int k) {
        boolean pushNumberSuccess = false;
        while (!pushNumberSuccess) {
            if (stack.isEmpty()) {
                stack.push(number);
                pushNumberSuccess = true;
                continue;
            }

            Integer stackTop = stack.peek();
            if (stackTop <= number) {
                stack.push(number);
                pushNumberSuccess = true;
            } else {
                stack.pop();
                removeNumber++;
                if (removeNumber == k) {
                    stack.push(number);
                    pushNumberSuccess = true;
                    removeEnd = true;
                }
            }
        }

    }

    private void removeStack(int k) {
        while (removeNumber < k && !stack.isEmpty()) {
            stack.pop();
            removeNumber++;
        }
    }

    private String getAnswer(String num, int index) {
        StringBuilder builder = new StringBuilder(num.length());
        while (!stack.isEmpty()) {
            Integer number = stack.pop();
            builder.insert(0, number);
        }

        if (index < num.length()) {
            builder.append(num.substring(index + 1));
        }

        String answer = builder.toString();
        while (answer.startsWith("0")) {
            answer = answer.substring(1);
        }
        if (answer.isEmpty()) {
            return "0";
        }
        return answer;
    }

    private Integer getNumber(String num, int index) {
        String charNumber = num.substring(index, index + 1);
        return Integer.valueOf(charNumber);
    }
}
