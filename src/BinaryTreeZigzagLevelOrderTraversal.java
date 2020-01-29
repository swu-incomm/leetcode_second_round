import java.util.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
//key point would be how do you add value to the result collection
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue  =new LinkedList<>();
        queue.offer(root);
        int flag = 0;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i<queueSize; i++) {
                TreeNode temp = queue.remove();
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
                if(flag %2 == 0) {
                    cur.add(temp.val);
                } else {
                    cur.add(0, temp.val);
                }
            }
            result.add(cur);
            flag++;
        }
        return result;
    }
}
