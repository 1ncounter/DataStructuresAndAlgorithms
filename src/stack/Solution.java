package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 有效的括号 isValid
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.empty()) return false;

                char topChar = stack.pop();
                if (ch == ')' && topChar != '(') return false;
                if (ch == '}' && topChar != '{') return false;
                if (ch == ']' && topChar != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int size = T.length;
        int[] result = new int[size];
        Arrays.fill(result, 0);

        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int t = stack.peek();
                System.out.println(stack.toString());
                System.out.println("t " + t);
                System.out.println("i " + i);
                stack.pop();
                result[t] = i - t;
            }
            stack.push(i);
        }

        return result;
    }

    public int evalRPN(String[] tokens) {
        return 1;
    }
}
