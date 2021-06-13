import java.util.HashMap;

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
 *    1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 *
 *    两个重点， 第一是传参数
 *    第二是如何判断return null
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

        HashMap <Integer, Integer> inorderMap = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for(int i=0; i<inorder.length; i++) {
                this.inorderMap.put(inorder[i], i);
            }
            TreeNode root = construct(preorder, inorder, 0, inorder.length-1, 0);
            return root;
        }
        public TreeNode construct(int []preorder, int [] inorder, int inorderL, int inorderR, int preStart) {
            if(inorderL < inorderR) return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            int inOrderIndex = this.inorderMap.get(preorder[preStart]);
            root.left = construct(preorder, inorder, inorderL, inOrderIndex-1, preStart + 1);
            root.right = construct(preorder, inorder, inOrderIndex + 1, inorderR, preStart + inOrderIndex - inorderL + 1);
            return root;
        }
}
