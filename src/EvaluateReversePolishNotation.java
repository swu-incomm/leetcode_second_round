import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class EvaluateReversePolishNotation {
    /*
    public int evalRPN(String[] tokens) {
        int ans = 0;
        if(tokens == null || tokens.length ==0) return ans;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<tokens.length; i++) {
            if(tokens[i].equals("+")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v1+v2);
            } else if(tokens[i].equals("-")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2-v1);
            } else if(tokens[i].equals("*")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v1*v2);
            } else if(tokens[i].equals("/")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2/v1);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

     */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i=0; i<tokens.length; i++) {
            String temp = tokens[i];
            if(temp.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            }
            else if(temp.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if(temp.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            }
            else if(temp.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
            else {
                stack.push(Integer.valueOf(temp));
            }
        }
        return stack.pop();
    }
}
