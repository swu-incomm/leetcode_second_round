import java.util.*;
public class PreOrderTraversalBinaryTree {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(true) {
            while(current != null) {
                stack.push(current);
                ans.add(current.val);
                current = current.left;
            }
            if(!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                current = temp.right;
            } else {
               break;
            }
        }
        return ans;
    }
}
