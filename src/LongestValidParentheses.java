import java.util.*;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0;
        if(s == null || s.length() <=1) return res;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == '(') {
                stack.push(i);
            }
            else if(temp == ')') {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(i - stack.peek(), res);
                }
            }
        }
        return res;
    }
}
