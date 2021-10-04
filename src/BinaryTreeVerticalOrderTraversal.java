/**
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values.
 * (i.e., from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Example 2:
 *
 *
 * Input: root = [3,9,8,4,0,1,7]
 * Output: [[4],[9],[3,0,1],[8],[7]]
 * Example 3:
 *
 *
 * Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 * Example 4:
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
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer, List<Integer>> map =  new HashMap<>();
        Queue<TreeIndex> queue = new LinkedList<>();
        queue.offer(new TreeIndex(0, root));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeIndex temp = queue.poll();
                int index = temp.index;
                TreeNode node = temp.node;
                if(node != null) {
                    if(!map.containsKey(index)) {
                        map.put(index, new ArrayList<>());
                    }
                    List<Integer> list = map.get(index);
                    list.add(node.val);
                    map.put(index, list);
                    if(node.left != null) {
                        queue.offer(new TreeIndex(index-1, node.left));
                    }
                    if(node.right != null) {
                        queue.offer(new TreeIndex(index + 1, node.right));
                    }
                }
            }
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        for(int i : keyList) {
            res.add(map.get(i));
        }
        return res;
     }
}

class TreeIndex {
    int index;
    TreeNode node;

    public TreeIndex(int index, TreeNode node) {
        this.index = index;
        this.node = node;
    }
}
