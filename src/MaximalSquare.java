/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {
//    public int maximalSquare(char[][] matrix) {
//        int ans = 0;
//        if(matrix == null || matrix.length == 0) return ans;
//        int [][] dp = new int [matrix.length][matrix[0].length];
//        for(int i = 0; i< matrix.length ;i++) {
//            if(matrix[i][0] == '1') {dp[i][0] = 1;
//            ans= 1;}
//        }
//        for(int i = 0; i< matrix[0].length ;i++) {
//            if(matrix[0][i] == '1') {dp[0][i] = 1;
//            ans = 1;}
//        }
//        if(matrix.length == 1 || matrix[0].length ==1) {
//            return ans;
//        }
//        for(int i = 1; i<matrix.length; i++) {
//            for(int j = 1; j<matrix[0].length;j++) {
//                if(matrix[i][j] == '1') {
//                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1]) + 1;
//                    ans = Math.max(dp[i][j], ans);
//                }
//            }
//        }
//        return ans * ans;
//    }
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int [m][n];
        for(int i=0; i<matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(dp[i][0], max);
        }
        for(int i=0; i<matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(dp[0][i], max);
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
    public static void main(String [] args) {
        char [][] test = {
                {'0', '1'},
                {'1', '0'}
        };
        MaximalSquare maximalSquare = new MaximalSquare();
        maximalSquare.maximalSquare(test);
    }
}
