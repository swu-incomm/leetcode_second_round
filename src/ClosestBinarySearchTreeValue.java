/**
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 * Output: 4
 * Example 2:
 *
 * Input: root = [1], target = 4.428571
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 109
 * -109 <= target <= 109
 */
public class ClosestBinarySearchTreeValue {
    double min = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        int res = 0;
        while(root != null) {
            double diff = Math.abs(root.val - target);
            if(diff < min) {
                min = diff;
                res = root.val;
            }
            if(target >= (double) root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }
}
