/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 */
import java.util.*;
public class BasicCalculatorII {
    public static int calculate(String s) {
        int ans = 0, cur = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        char [] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++) {
            if(Character.isDigit(chars[i])) {
                cur = cur * 10 + chars[i] - '0';
            } if((!Character.isDigit(chars[i]) && chars[i] != ' ') || i == chars.length-1) {
                if(op == '+') {
                    stack.push(cur);
                }else if(op == '-'){
                    stack.push(-cur);
                } else if(op == '*') {
                    stack.push(stack.pop() * cur);
                } else if(op == '/') {
                    stack.push(stack.pop() / cur);
                }
                cur = 0;
                op = chars[i];
            }
        }
        while(!stack.isEmpty()) {
            ans+=stack.pop();
        }
        return ans;
    }

    public static void main(String [] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }
}
/*
        public int calculate(String s) {
        char sign = '+';
        int res = 0;
        int tempInt = 0;
        Stack<Integer> stack = new Stack<>();
        char [] chars = s.toCharArray();
        int i=0;
        while(i<chars.length) {
            char temp = chars[i];
            if(temp == ' ') {
                i++;
                continue;
            }
            if(Character.isDigit(temp)) {
                tempInt+=temp - '0';
                while(++i<chars.length && Character.isDigit(chars[i])) {
                    tempInt = tempInt * 10 + chars[i] - '0';
                }
                if(sign == '+') {
                    stack.push(tempInt);
                } else if (sign == '-'){
                    stack.push(-1 * tempInt);
                } else if(sign == '/') {
                    stack.push(stack.pop() / tempInt);
                } else if (sign == '*') {
                    stack.push(stack.pop() * tempInt);
                }
                tempInt = 0;
            } else {
                sign = temp;
                i++;
            }
        }
        for(int num : stack) {
                res+=num;
            }
        return res;
    }
* */