/**
 * 98. Validate Binary Search Tree
 * Medium
 *
 * 3092
 *
 * 445
 *
 * Add to List
 *
 * Share
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    //问题在于只判断了当前的子树 没有做一个全局的判断
    public boolean isValidBSTIntuitive(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null) {
            if(root.val >= root.right.val) {
                System.out.println(root.val + "***" + root.right.val + " you");
                return false;
            }
        }
        if(root.right == null) {
            if(root.val <= root.left.val) {
                System.out.println(root.val + "***" + root.left.val + " zuo");
                return false;
            }
        }
        if(root.left != null && root.right != null){
            if(root.val <= root.left.val || root.val >= root.right.val){
                System.out.println(root.val + "***" + root.left.val + "***" + root.right.val);
                return false;
            }
        }
        return (isValidBST(root.left) && isValidBST(root.right));
    }
    public static void main(String [] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(20);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right =e;
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(a));
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long low, long high) {
        if(root == null) return true;
        System.out.println(root.val + " " + low + " " + high);
        if(root.val >= high || root.val<=low) return false;
        if(root.left == null && root.right == null) return true;
        if(root.left == null) {
            if(root.val >= root.right.val) {
                return false;
            }
        }
        if(root.right == null) {
            if(root.val <= root.left.val) {
                return false;
            }
        }
        if(root.left != null && root.right != null){
            if(root.val <= root.left.val || root.val >= root.right.val){
                return false;
            }
        }
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}
