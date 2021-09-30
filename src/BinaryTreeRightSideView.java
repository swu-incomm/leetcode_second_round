/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                if(temp.right != null) queue.offer(temp.right);
                if(temp.left != null) queue.offer(temp.left);
                sub.add(temp.val);
            }
            traversal.add(sub);
        }
        List<Integer> res = traversal.stream().map(a -> a.get(0)).collect(Collectors.toList());
        return res;
    }
}
