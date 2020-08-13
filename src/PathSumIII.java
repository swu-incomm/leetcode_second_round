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
 */
public class PathSumIII {
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        List<Integer> record = new ArrayList<>();
        dfs(root, sum, record);
        return ans;
    }

    public void dfs(TreeNode root, int sum, List<Integer> record) {
        if(root == null) return;
        record.add(root.val);

        dfs(root.left, sum, record);
        dfs(root.right, sum, record);

        int temp = 0;
        for(int i = record.size()-1; i>=0; i--) {
            temp += record.get(i);
            if(temp == sum) ans++;
        }
        record.remove(record.size()-1);
    }
}
