/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level
 * it does not matter the order on which elements are returned.
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
import java.util.*;
public class FindLeavesOfBinaryTree {
    List<Pair> temp = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        btDepth(root);
        Collections.sort(this.temp, (a, b) -> b.getKey() - a.getKey());
        List<List<Integer>> res =new ArrayList<>();
        int n = temp.get(0).getKey();
        for(int i=n; i>=1; i--) {
            List<Integer> sub = new ArrayList<>();
            for(Pair p : temp) {
                if(p.getKey() == n) {
                    sub.add(p.getValue());
                }
            }
            res.add(sub);
        }
        return res;
    }

    public int btDepth(TreeNode root) {
        if(root == null) return 0;
        int res =  1 + Math.max(btDepth(root.left), btDepth(root.right));
        this.temp.add(new Pair(res, root.val));
        return res;
    }
}

class Pair {
    private int key;
    private int value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}