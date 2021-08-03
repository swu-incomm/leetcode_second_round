/**
 * Given the root of a binary tree, return the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The longest consecutive path needs to be from parent to child (cannot be the reverse).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,3,2,4,null,null,null,5]
 * Output: 3
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 * Example 2:
 *
 *
 * Input: root = [2,null,3,2,null,1]
 * Output: 2
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -3 * 104 <= Node.val <= 3 * 104
 */
public class BinaryTreeLongestConsecutiveSequence {
    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.left != null && root.val == root.left.val - 1) {
            left += 1;
        } else {
            left = 1;
        }
        if(root.right != null && root.val == root.right.val - 1 ) {
            right +=1;
        } else {
            right = 1;
        }
        int res = Math.max(left, right);
        ans = Math.max(ans, res);
        return res;
    }
}
