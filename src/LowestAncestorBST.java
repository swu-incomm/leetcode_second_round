public class LowestAncestorBST {
    public int bstDistance(TreeNode root, int node1, int node2) {
        if (root == null) return -1;
        TreeNode lca = lca(root, node1, node2);
        return getDistance(lca, node1) + getDistance(lca, node2);
    }

    private int getDistance(TreeNode src, int dest) {
        if (src.val == dest) return 0;
        TreeNode node = src.left;
        if (src.val < dest) {
            node = src.right;
        }
        return 1 + getDistance(node, dest);
    }

    private TreeNode lca(TreeNode root, int node1, int node2) {
        while (true) {
            if (root.val > node1 && root.val > node2) {
                root = root.left;
            } else if (root.val < node1 && root.val < node2) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
    private TreeNode lcaInBST(TreeNode root, int node1, int node2) {
        while(root != null) {
            if(root.val < node1 && root.val < node2) {
                root = root.right;
            } else if(root.val > node1 && root.val >node2) {
                root = root.left;
            } else {
                return root;
            }
        }
        //no answer
        return null;
    }

    TreeNode bt;
    private boolean lcaInBT(TreeNode root, int node1, int node2) {
        if(root == null) return false;
        int mid = 0;
        if(root.val == node1 || root.val == node2) mid = 1;
        int left = lcaInBT(root.left, node1, node2) ? 1 : 0;
        int right = lcaInBT(root.right, node1, node2) ? 1 : 0;
        if(mid + left + right == 2) bt = root;
        return mid + left + right > 0 ? true : false;
    }

    private int getDistanceInBT(TreeNode root, TreeNode target, int level) {
        if(root == null) return -1;
        if(root.val == target.val) return level;
        int l = getDistanceInBT(root.left, target, level + 1);
        return (l != -1) ? l : getDistanceInBT(root.right, target, level + 1);
    }
}
