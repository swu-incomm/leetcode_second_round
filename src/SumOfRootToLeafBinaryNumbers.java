import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.Stack;

/**
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number
 * starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary,
 * which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 */
public class SumOfRootToLeafBinaryNumbers {
    int ans;
    public int sumRootToLeaf(TreeNode root) {
        preOrder(root, 0);
        return ans;
    }

    public void preOrder(TreeNode root, int cur) {
        if(root == null) return;
        cur = cur<<1 | root.val;
        if(root.left == null && root.right == null) {
            ans += cur;
        }
        preOrder(root.left, cur);
        preOrder(root.right, cur);
    }

    //still preorder solution
    public int sumRootToLeafIterative(TreeNode root) {
        int answer = 0;
        if(root == null) return answer;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if(temp.left == null && temp.right == null) {
                answer += temp.val;
            }
            if(temp.right != null) {
                temp.right.val = temp.val * 2 + temp.right.val;
                stack.push(temp.right);
            }
            if(temp.left != null) {
                temp.left.val = temp.val * 2 + temp.left.val;
                stack.push(temp.left);
            }
        }
        return answer;
    }
}
