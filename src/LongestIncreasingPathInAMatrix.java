/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down.
 * You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 *
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 */
public class LongestIncreasingPathInAMatrix {
    // no more talk, dfs
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        int dp [][] = new int [m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int temp = dfs(matrix, i, j, m, n, dp);
                if(temp > max) max = temp;
            }
        }
        return max;
    }
    int [][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    int dfs(int [][] matrix, int i, int j, int m, int n, int [][] dp) {
        if(dp[i][j] > 0) return dp[i][j];
        int max = 0;
        for (int [] direction : directions ) {
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >= 0 && x < m && y>=0 && y<n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, x, y, m, n, dp));
            }
        }
        dp[i][j] = max + 1;
        return 1 + max;
    }
}
