import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return ans;
        dfs(root, sum, new ArrayList<>());
        return ans;
    }
    public void dfs(TreeNode root, int sum, List<Integer> subList) {
        if (root == null) return;
        int temp = sum - root.val;
        subList.add(root.val);
        if(temp == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(subList));
        } else {
            dfs(root.left, temp, subList);
            dfs(root.right, temp, subList);
        }
        subList.remove(subList.size()-1);
    }
}
