package problem_402;

import java.util.Stack;

/**
 * 执行用时：7ms，超过80.55%
 * 内存消耗：40.1MB，超过5.6%
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
