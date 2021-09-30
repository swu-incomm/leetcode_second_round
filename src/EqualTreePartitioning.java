/**
 * Given the root of a binary tree, return true if you can partition the tree into two trees with equal sums
 * of values after removing exactly one edge on the original tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,10,10,null,null,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,10,null,null,2,20]
 * Output: false
 * Explanation: You cannot split the tree into two trees with equal sums after removing exactly one edge on the tree.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 */
import java.util.*;
public class EqualTreePartitioning {
    List<Integer> sums = new ArrayList<>();
    public boolean checkEqualTree(TreeNode root) {
        int sum = getSum(root);
        if(sum %2 != 0) return false;
        sums.remove(sums.size() -1);
        for(int i=0; i<sums.size(); i++) {
            if(sum - sums.get(i) == sums.get(i)) return true;
        }
        return false;
    }

    public int getSum(TreeNode root) {
        if(root == null) return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        int temp = root.val + left + right;
        sums.add(temp);
        return temp;
    }

    public static void main(String [] args) {
       Test test1 = new Test();
       setValue(test1);
       System.out.println(test1.a + " " + test1.b);
    }

    public static void setValue (Test test) {
        test = new Test();
        test.a = 1;
        test.b = 2;
    }
}


class Test {
    int a;
    int b;
}

