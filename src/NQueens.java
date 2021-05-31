/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both
 * indicate a queen and an empty space, respectively.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
import java.util.*;
public class NQueens {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        List<int []> queensPos = new ArrayList<>();
        char [][] matrix = new char[n][n];
        for(char[] i : matrix) Arrays.fill(i, '.');
        // the third param is the row
        backtrack(matrix, queensPos, 0);
        return ans;
    }

    public void backtrack(char [][] matrix, List<int []> queensPos, int row) {
        if(queensPos.size() == matrix.length) {
            List<String> subAns = new ArrayList<>();
            for(int i=0; i<matrix.length; i++) {
                subAns.add(new String(matrix[i]));
            }
            ans.add(subAns);
            return;
        }
        if(row >= matrix.length) return;
        for(int i=0; i<matrix[0].length; i++) {
            if(canAdd(row, i, queensPos)) {
                matrix[row][i] = 'Q';
                queensPos.add(new int [] {row, i});
                backtrack(matrix, queensPos, row + 1);
                matrix[row][i] = '.';
                queensPos.remove(queensPos.size()-1);
            }
        }
    }

    public boolean canAdd(int row, int col, List<int []> queensPos) {
        for(int i=0; i<queensPos.size(); i++) {
            int dx=Math.abs(queensPos.get(i)[0] - row);
            int dy=Math.abs(queensPos.get(i)[1] - col);
            if(dx == dy || dx == 0 || dy == 0) return false;
        }
        return true;
    }
}
