/**
 * Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST.
 * If the given node has no in-order successor in the tree, return null.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the answer is null.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 * All Nodes will have unique values.
 */
public class InorderSuccessorInBST {
    TreeNode prev = null;
    TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //handle case 1, p has right child, so we only needs to find the most left child of the right subtree of p
        if(p.right != null) {
            p = p.right;
            while (p!= null) {
                ans = p;
                p = p.left;
            }
            return ans;
        }
        handleNoRightChild(root, p);
        return ans;
    }

    public void handleNoRightChild(TreeNode root, TreeNode p) {
        if(root == null) return;
        handleNoRightChild(root.left, p);
        if(prev != null && prev.val == p.val && ans == null) {
            ans = root;
            //return to upper layer, this time prev is not updated, so we need also check ans == null
            return;
        }
        prev = root;
        handleNoRightChild(root.right, p);
    }

    //iterative solution
    public TreeNode inorderSuccessorIterative(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while(root != null) {
            if(root.val > p.val) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}
