import java.util.Arrays;

/**
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 * You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing
 * the grid boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of
 * the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * Example 2:
 *
 *
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 */
public class OutOfBoundryPaths {
    //brute force approach would be using recursive backtracking approach
    public int findPathsBruteForce(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow < 0 || startRow >= m || startColumn <0 || startColumn >= n) {
            return 1;
        }
        if(maxMove == 0) return 0;
        long res =  findPathsBruteForce(m, n, maxMove-1, startRow -1, startColumn) +
                findPathsBruteForce(m, n, maxMove-1, startRow +1, startColumn) +
                findPathsBruteForce(m, n, maxMove-1, startRow , startColumn-1) +
                findPathsBruteForce(m, n, maxMove-1, startRow , startColumn+1);
        if(res > Integer.MAX_VALUE) {
            return (int) res%1000000007;
        }
        return (int)res;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int [][][] dp = new int [maxMove+1][m][n];
        for(int [][] sub : dp) {
            for(int [] secSub : sub) {
                Arrays.fill(secSub, -1);
            }
        }
        return backtrack(m, n, maxMove, startRow, startColumn, dp);
    }
    public int backtrack(int m, int n, int maxMove, int startRow, int startColumn, int [][][] dp) {
        if(startRow < 0 || startRow >= m || startColumn <0 || startColumn >= n) {
            return 1;
        }
        if(maxMove == 0) return 0;
        if(dp[maxMove][startRow][startColumn] != -1) {
            return dp[maxMove][startRow][startColumn];
        }
        dp[maxMove][startRow][startColumn] =  ((backtrack(m, n, maxMove-1, startRow -1, startColumn, dp) +
                backtrack(m, n, maxMove-1, startRow +1, startColumn, dp))%1000000007 +
                (backtrack(m, n, maxMove-1, startRow , startColumn-1, dp) +
                backtrack(m, n, maxMove-1, startRow , startColumn+1, dp))%1000000007)%1000000007;
        return dp[maxMove][startRow][startColumn];
    }
}
