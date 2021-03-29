

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    两个重点， 第一是传参数
 *    第二是如何判断return null
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode helper(int [] preOrder, int [] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preOrder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = 0;
        for(int i = inStart; i<=inEnd; i++) {
            if(inOrder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = helper(preOrder, inOrder, preStart + 1, preStart + index-inStart, inStart, index-1);
        root.right = helper(preOrder, inOrder, preStart + index - inStart +1, preEnd, index + 1, inEnd);
        return root;
    }
}
