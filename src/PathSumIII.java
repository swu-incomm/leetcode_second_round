import java.util.ArrayList;
import java.util.List;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class PathSumIII {
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return ans;
        List<Integer> list = new ArrayList<>();
        dfs(root, targetSum, list);
        return ans;
    }

    public void dfs(TreeNode root, int target, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        dfs(root.left, target, list);
        dfs(root.right, target, list);
        int temp = 0;
        for(int i = list.size()-1; i>=0; i--) {
            temp += list.get(i);
            if(temp == target) {
                ans++;
            }
        }
        list.remove(list.size()-1);
    }
}
