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
        flatten(root.left);
        flatten(root.right);

        if(root.left!= null) {
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            //we need a temp variable to save root
            TreeNode leftLastNode = root;
            while(leftLastNode.right != null) {
                leftLastNode = leftLastNode.right;
            }
            leftLastNode.right = tempRight;
        }
    }
}
