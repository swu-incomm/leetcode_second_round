/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 * Constraints:
 *
 * 1 <= n <=
 * 解法为让每一个节点依次作为root node， 通过左子树和右子树的个数所形成的不同排列组合相乘， 找到规律
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        int [] catalan = new int [n + 1];
        catalan [0] = 1;
        catalan [1] = 1;
        for(int i = 2; i<=n; i++) {
            for(int j = 0; j<i; j++) {
                catalan[i] += catalan[j] * catalan[i-j-1];
            }
        }
        return catalan[n];
    }
}
