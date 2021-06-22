/**
 * Given weights and values of n items,
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items
 * respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of
 * the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it
 * (0-1 property).
 */
public class KnapSack {

    //from top to bottom
    public int recursiveKnapsack(int w, int [] wt, int [] val) {
        return backtrack(w, wt, val, val.length);
    }

    public int backtrack(int w, int wt[], int val[], int index) {
        if(w == 0 || index == 0) {
            return 0;
        }
        if(wt[index-1] > w) {
            return backtrack(w, wt, val, index-1);
        }
        return Math.max(val[index-1] + backtrack(w-wt[index-1], wt, val, index-1), backtrack(w, wt, val, index-1));
    }

    public int knapSack(int w, int [] wt, int [] val) {
        int [][] dp = new int [wt.length][w];
        for(int i=0; i<wt.length; i++) {
            for(int j=0; j<=w; j++) {
                if(i==0 || j==0) {
                    dp[i][j] =0;
                }
                else if(j - wt[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j-wt[i]] + val[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[wt.length-1][w];
    }
}
