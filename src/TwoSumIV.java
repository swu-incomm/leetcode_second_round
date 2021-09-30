/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such
 * that their sum is equal to the given target.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 * Example 3:
 *
 * Input: root = [2,1,3], k = 4
 * Output: true
 * Example 4:
 *
 * Input: root = [2,1,3], k = 1
 * Output: false
 * Example 5:
 *
 * Input: root = [2,1,3], k = 3
 * Output: true
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -104 <= Node.val <= 104
 * root is guaranteed to be a valid binary search tree.
 * -105 <= k <= 105
 */
import java.util.*;
public class TwoSumIV {
    public boolean findTargetDFS(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    public boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if(root == null) return false;
        if(set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }

    //Inorder traversal
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        //stack.push(root);
        while (true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            list.add(root.val);
            if(root.right != null) {
                root = root.right;
            }
        }
        int left = 0, right = list.size()-1;
        while(left < right) {
            int temp = list.get(left) + list.get(right);
            if(temp == k) {
                return true;
            }
            else if(temp > k) {
                right--;
            } else {
                left++;
            }

        }
        return false;
    }
}
