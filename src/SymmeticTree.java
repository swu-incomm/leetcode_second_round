/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


Note:
Bonus points if you could solve it both recursively and iteratively.
 */


public class SymmeticTree {

    //Recursive solution
    public boolean isSymmetric(TreeNode root) {
       if(root == null) return true;
       return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right) {
        //at lease one node is empty
        if(left==null || right == null) return left == right;
        else if(left.val != right.val) return false;
        else return (helper(left.left, right.right) && (helper(left.right, right.left)));
    }
}
