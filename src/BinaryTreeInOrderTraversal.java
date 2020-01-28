import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInOrderTraversal {

    //Recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return null;
        recursiveHelper(root, result);
        return result;
    }
    private void recursiveHelper(TreeNode root, List<Integer> result) {
        if(root != null) {
            if(root.left != null)
            recursiveHelper(root.left, result);
            result.add(root.val);
            if(root.right!=null)
            recursiveHelper(root.right, result);
        }
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack  = new Stack<>();
        TreeNode cur = root;
        //push to queue all the way to the end of left child
        //then simulate the process of recursive
        //pop the top of the node from stack and then check the right child and see if right child can do the same process
        //otherwise kepp poping
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null) {
                stack.push(cur);
                cur= cur.left;
            }
            TreeNode temp = stack.pop();
            result.add(temp.val);
            cur = temp.right;
        }
        return result;
    }

}
