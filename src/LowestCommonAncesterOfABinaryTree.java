

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p
 * and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncesterOfABinaryTree {

//    public static TreeNode res;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        helper( root,  p,  q);
//        return res;
//    }
//
//    public int helper(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null) return 0;
//        int left = helper(root.left, p, q);
//        int right = helper(root.right, p, q);
//        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
//        if((left + right + mid) >= 2) {
//            this.res = root;
//        }
//        return (left + right + mid >0 ? 1 : 0);
//    }
TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        int midVal = 0;
        if(root.val == p.val || root.val == q.val) midVal = 1;
        int leftVal = dfs(root.left, p, q) ? 1 : 0;
        int rightVal = dfs(root.right, p, q) ? 1 : 0;
        if(midVal + leftVal + rightVal == 2) ans = root;
        return midVal + leftVal + rightVal >0 ? true : false;
    }
}
