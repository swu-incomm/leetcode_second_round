/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
       if(root == null) return;
       TreeNode tempLeft = root.left;
       TreeNode tempRight = root.right;

       flatten(tempLeft);
       flatten(tempRight);

       root.left = null;
       root.right = tempLeft;
       while(root.right!= null) {
           root = root.right;
       }
       root.right = tempRight;
    }
}
