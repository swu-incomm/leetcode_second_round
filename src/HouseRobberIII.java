/**
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root." Besides the root,
 * each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms
 * a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int [] arr = helper(root);
        return Math.max(arr[0], arr[1]);
    }

    // a 2-size int array, index 0 represent money of rob root, index 1 represent not rob root money
    int [] helper(TreeNode root) {
        if(root == null) {
            return new int [] {0, 0};
        }
        int [] arr = new int[2];
        int [] arrLeft = helper(root.left);
        int [] arrRight = helper(root.right);
        arr[0] = root.val + arrLeft[1] + arrRight[1];
        arr[1] = Math.max(arrLeft[0], arrLeft[1]) + Math.max(arrRight[0], arrRight[1]);
        return arr;
    }
}
