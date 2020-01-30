import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInABST {
    //Solution will be inorder traversal and get the kth index
    public int kthSmallest(TreeNode root, int k) {
        int result = 0;
        List<Integer> treeArray = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            treeArray.add(temp.val);
            cur = temp.right;
        }
//        treeArray.stream().forEach(System.out::println);
//        System.out.println();
        return treeArray.get(k-1);
    }

    public static void main(String [] args) {
        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        e.left = c;
        e.right = f;
        c.left = b;
        c.right = d;
        b.left = a;
        System.out.println(kthSmallestElementInABST.kthSmallest(e, 3));
    }
}
