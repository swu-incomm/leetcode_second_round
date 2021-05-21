import java.util.HashSet;

/**
 * You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a
 * node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 * Example 2:
 *
 *
 * Input: root = [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one
 * of the valid configurations of camera placement.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * Node.val == 0
 *
 *
 * To solve this problem, we always want to start from bottom up to the root
 */
public class BinaryTreeCameras {
    int ans = 0;
    HashSet<TreeNode> hashSet = new HashSet<>();
    public int minCameraCover(TreeNode root) {
        hashSet.add(null);
        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode cur, TreeNode parent) {
        if(cur == null) return;
        dfs(cur.left, cur);
        dfs(cur.right, cur);

        if((parent == null && !hashSet.contains(cur))||
                !hashSet.contains(cur.left)||
                !hashSet.contains(cur.right)) {
            hashSet.add(cur);
            hashSet.add(cur.left);
            hashSet.add(cur.right);
            hashSet.add(parent);
            ans++;
        }
    }
}
