import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null) return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length();i++) {
            char cur = s.charAt(i);
            if(cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            }
            else if(cur == ')') {
                if(stack.empty() || stack.pop() != '(' ) return false;
            }
            else if(cur == ']') {
                if(stack.empty() || stack.pop() != '[' ) return false;
            }
            else {
                if(stack.empty() || stack.pop() != '{' ) return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
