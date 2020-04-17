import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom
 * right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return Integer.MAX_VALUE;
        int r = grid.length;
        int c = grid[0].length;
        int [][] dp = new int [r][c];
        dp[0][0] = grid[0][0];
        for(int i = 1; i<c; i++) dp[0][i] = grid[0][i] + dp[0][i-1];
        for(int i = 1; i<r; i++) dp[i][0] = grid[i][0] + dp[i-1][0];
        for(int i = 1; i<r; i++) {
            for(int j = 1; j<c; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        for(int i = 0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                System.out.printf("%d ", dp[i][j]);
            }
            System.out.println();
        }
        return dp[r-1][c-1];
    }

    public static void main(String [] args) {
        int [][] test = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int [][] test2 = {
                {1,3},
                {1,2}
        };
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        minimumPathSum.minPathSum(test2);
    }
}
