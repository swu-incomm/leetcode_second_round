/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the
 * evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Example 4:
 *
 * Input: s = "+48 + -48"
 * Output: 0
 * Explanation: Numbers can have multiple digits and start with +/-.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * Every number and running calculation will fit in a signed 32-bit integer.
 * //-3-(-4-(5-6))
 *
 */
import java.util.*;
public class BasicCalculator {
    //this solution make use of a stack to store the most recent sign before a '('
    //"+" & "+" -> "+"
    //"+" & "-" -> "-"
    //"-" & "+" -> "-"
    //"-" & "-" -> "-"
    //if current is a digit, we just accumulate and make up the final number
    //if current is a operator or we have reached the last of the index of the char array
    //we need to apply the last(most recent) operator we have temp stored to add to our final sum
    //then when we try to update the op, we need to check if the stack is empty or not, if it is empty, which means
    // there is not a '(' before this operator, we can just go with the sign itself
    //otherwise we need to compare current operator with the one stored in the stack
    //-3-(-4-(5-6)) before "..(5-6)..", it is actually +5-6
    //in the second '(',
    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        char op = '+';
        int res = 0, cur = 0;
        char [] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++) {
            char ch = chars[i];
            if(Character.isDigit(ch)) {
                cur  = cur * 10 + ch - '0';
            }
            if(isOperator(ch) || i == chars.length - 1) {
                res += op == '+' ? cur : -cur;
                cur = 0;
                if(stack.isEmpty()) {
                    op = ch;
                } else {
                    op = stack.peek() == ch ? '+' : '-';
                }
            }
            else if(ch == '(') {
                stack.push(op);
            }
            else if(ch == ')') {
                stack.pop();
            }
        }
        return res;
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-';
    }
}