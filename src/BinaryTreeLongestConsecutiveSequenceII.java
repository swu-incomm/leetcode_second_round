/**
 * Given the root of a binary tree, return the length of the longest consecutive path in the tree.
 *
 * This path can be either increasing or decreasing.
 *
 * For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid.
 * On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -3 * 104 <= Node.val <= 3 * 104
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }

    public int [] dfs(TreeNode root) {
        if(root == null) {
            return new int [] {0, 0};
        }
        int ival = 1, dval = 1;
        if(root.left != null) {
            int [] left = dfs(root.left);
            if(root.val == root.left.val + 1) {
                dval = Math.max(dval, left[1] + 1);
            }else if(root.val == root.left.val - 1) {
                ival = Math.max(ival, left[0] + 1);
            }
        }

        if(root.right != null) {
            int [] right = dfs(root.right);
            if(root.val == root.right.val + 1) {
                dval = Math.max(dval, right[1] + 1);
            }else if(root.val == root.right.val - 1) {
                ival = Math.max(ival, right[0] + 1);
            }
        }
        if(ival + dval -1 > res) {
            res = ival + dval -1;
        }
        return new int [] {ival, dval};
    }
}
