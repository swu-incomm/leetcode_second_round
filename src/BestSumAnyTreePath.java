import java.util.*;

public class BestSumAnyTreePath {
    static class TreeNode {
        int val;
        List<TreeNode> subNodes = new ArrayList<>();
        TreeNode (int val) {
            this.val = val;
        }
    }
    static int maxSum = Integer.MIN_VALUE;
    static List<TreeNode> globalNodeList = new ArrayList<>();
    public static int bestSumAnyTreePath(List<Integer> parent, List<Integer> values) {
        if(parent.size() == 0 || values.size() == 0) return 0;
        for(int i=0; i<values.size(); i++) {
            TreeNode node = new TreeNode(values.get(i));
            globalNodeList.add(node);
        }
        for(int i=1; i<parent.size(); i++) {
            int jIndex = parent.get(i);
            globalNodeList.get(jIndex).subNodes.add(globalNodeList.get(i));
        }
        TreeNode root = globalNodeList.get(0);
        dfs(root);
        return maxSum;
    }

    public static int dfs(TreeNode node) {
        List<TreeNode> nodeList = node.subNodes;
        if(nodeList.size() > 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0; i<nodeList.size(); i++) {
                TreeNode tempNode = nodeList.get(i);
                pq.offer(dfs(tempNode));
                if(pq.size() > 2) pq.poll();
            }
            int secLargest = pq.size() > 0 ? pq.poll() : 0;
            int firLargest = pq.poll() > 0 ? pq.poll() : 0;
            int newPathVal = secLargest + firLargest + node.val;
            maxSum = Math.max(maxSum, newPathVal);
            return node.val + firLargest;
        } else {
            return node.val;
        }
    }
}
