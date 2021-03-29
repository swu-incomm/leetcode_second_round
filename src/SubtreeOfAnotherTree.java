/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */
public class SubtreeOfAnotherTree {
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if(s == null || t == null) {
//            return false;
//        }
//        return treeToString(s, false).indexOf(treeToString(t, false))>= 0;
//    }
//    public String treeToString(TreeNode root, boolean isLeft) {
//        if(root == null) {
//            return isLeft ? "lnull" : "rnull";
//        }
//        return "#" + root.val + treeToString(root.left, true) + treeToString(root.right, false);
//    }
//
    public static void main(String [] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        a.left = b;
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        System.out.println(subtreeOfAnotherTree.constructTreeString(a, false));
        System.out.println(subtreeOfAnotherTree.constructTreeString(c, false));
        System.out.println(subtreeOfAnotherTree.isSubtree(a, c));

    }

    //solution one construct a tree string by pre-order
    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if(s == null && t ==null) return true;
//        else if(s==null || t==null) return false;
//        return constructTreeString(s, true).indexOf(constructTreeString(t, true))>=0;
        String tree1 = constructTreeString(s, true);
        String tree2 = constructTreeString(t, true);
        return tree1.indexOf(tree2) >= 0;

    }

    public String constructTreeString(TreeNode root, boolean isLeft) {
        if(root == null) {
            return isLeft ? "lnull": "rnull";
        }
        return "#"+root.val + " " +constructTreeString(root.left, true)+" " +constructTreeString(root.right, false);
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        } else if(isSameTree(s, t)) {
            return true;
        } else {
            return isSubtree2(s.left, t) || isSubtree2(s.right, t);
        }
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null || t==null) {
            return s==null && t==null;
        }
        else if(s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
        return false;
    }
}
