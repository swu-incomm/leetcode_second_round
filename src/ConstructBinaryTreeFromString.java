import java.util.Stack;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 *
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
 * The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "4(2(3)(1))(6(5))"
 * Output: [4,2,6,3,1,5]
 * Example 2:
 *
 * Input: s = "4(2(3)(1))(6(5)(7))"
 * Output: [4,2,6,3,1,5,7]
 * Example 3:
 *
 * Input: s = "-4(2(3)(1))(6(5)(7))"
 * Output: [-4,2,6,3,1,5,7]
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s consists of digits, '(', ')', and '-' only.
 */
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(Character.isDigit(c) || c == '-') {
                int startIndex = index;
                int endIndex = index + 1;
                while(endIndex < s.length() && Character.isDigit(s.charAt(endIndex))) {
                    endIndex ++;
                }
                int value = Integer.parseInt(s.substring(startIndex, endIndex));
                //System.out.println(value);
                TreeNode node = new TreeNode(value);
                //insert in to parent node
                if(!stack.isEmpty()) {
                    TreeNode parentNode = stack.peek();
                    if(parentNode.left == null) {
                        parentNode.left = node;
                    } else {
                        parentNode.right = node;
                    }
                }
                stack.push(node);
                index = endIndex;
            } else if (s.charAt(index) == ')') {
                //deal with close bracket, we need to pop out the value from stack and set as left or right child
                stack.pop();
            }
            index++;
        }
        return stack.pop();
    }

    public static void main(String [] args) {
        ConstructBinaryTreeFromString constructBinaryTreeFromString = new ConstructBinaryTreeFromString();
        constructBinaryTreeFromString.str2tree("-4(2(3)(1))(6(5)(7))");
    }
}