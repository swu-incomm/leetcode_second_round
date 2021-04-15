/**
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of y.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 * Example 2:
 *
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 */
public class OnesAndZeroes {
    //Recursive (time exceed limit)
    public int findMaxFormRecursive(String[] strs, int m, int n) {
        return helper(strs, m, n, 0);
    }

    private int helper(String[] strs, int m, int n, int index) {
        if(index == strs.length || m + n == 0) {
            return 0;
        }
        int [] count = count(strs[index]);
        int taken = 0;
        if(m - count[0] >=0 && n-count[1] >=0) {
            taken = helper(strs, m-count[0], n-count[1], index + 1) + 1;
        }
        int notTaken = helper(strs, m, n, index + 1);
        return Math.max(taken, notTaken);
    }

    private int [] count(String s) {
        int [] result = new int [2];
        if(s == null || s.length() == 0) return result;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            result[c-'0']++;
        }
        return result;
    }

    public static void main(String [] args) {
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        int a = 1;
        onesAndZeroes.test(a++);
        onesAndZeroes.test(++a);
        onesAndZeroes.test(a+1);
    }

    public void test(int a) {
        System.out.println(a);
    }

    int [][][]dp;
    public int findMaxFormRecursiveMemorized(String[] strs, int m, int n) {
        dp = new int [m+1][n+1][strs.length];
        return helperMemorized(strs, m, n, 0);
    }

    private int helperMemorized(String[] strs, int m, int n, int index) {
        if(index == strs.length || m + n == 0) {
            return 0;
        }
        if(dp[m][n][index] > 0) {
            return dp[m][n][index];
        }
        int [] count = count(strs[index]);
        int taken = 0;
        if(m - count[0] >=0 && n-count[1] >=0) {
            taken = helper(strs, m-count[0], n-count[1], index + 1) + 1;
        }
        int notTaken = helper(strs, m, n, index + 1);
        dp[m][n][index] = Math.max(taken, notTaken);
        return dp[m][n][index];
    }

    public int findMaxFormDP(String[] strs, int m, int n) {
        int [][] dp = new int [m+1][n+1];
        for(String str : strs) {
            int [] count = count(str);
            for(int zero = m; zero>= count[0]; zero--) {
                for(int one=n; one>=count[1]; one--) {
                    // dp[i][j] = the max number of strings that can be formed with i 0's and j 1's
                    // from the first few strings up to the current string s
                    // Catch: have to go from bottom right to top left
                    // Why? If a cell in the memo is updated(because s is selected),
                    // we should be adding 1 to memo[i][j] from the previous iteration (when we were not considering s)
                    // If we go from top left to bottom right, we would be using results from this iteration => overcounting
                    dp[zero][one] = Math.max(1 + dp[zero-count[0]][one-count[1]], dp[zero][one]);
                }
            }
        }
        return dp[m][n];
    }
}
