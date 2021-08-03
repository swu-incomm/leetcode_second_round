/**
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * Example 2:
 *
 * Input: root = [1], target = 1, k = 3
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 */
import java.util.*;
public class AllNodesDistanceKInBinaryTree {
    Map<TreeNode, TreeNode> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        map = new HashMap<>();
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int distance = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;
                if(distance == k) {
                for(int i=0; i<size; i++) {
                    res.add(queue.poll().val);
                }
                return res;
            }
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }
                if(map.get(node)!=null && !visited.contains(map.get(node))) {
                    queue.offer(map.get(node));
                    visited.add(map.get(node));
                }
            }
        }
        return res;
    }

    public void dfs(TreeNode root, TreeNode parent) {
        if(root == null) return;
        map.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}
