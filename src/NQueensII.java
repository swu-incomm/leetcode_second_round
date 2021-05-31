/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
import java.util.*;
public class NQueensII {
    int ans;
    public int totalNQueens(int n) {
        int [][] matrix = new int [n][n];
        List<int []> queens = new ArrayList<>();
        backtrack(0, queens, n);
        return ans;
    }

    public void backtrack(int row, List<int []> queens, int n) {
        if(queens.size() == n) {
            ans++;
            return;
        }
        //column
        for(int i=0; i<n; i++) {
            if(canAdd(row, i, queens)) {
                int [] newCoor = {row, i};
                queens.add(newCoor);
                backtrack(row + 1, queens, n);
                queens.remove(queens.size()-1);
            }
        }
    }

    public boolean canAdd(int row, int col, List<int []> queens) {
        for(int i=0; i<queens.size(); i++) {
            int [] coordinate = queens.get(i);
            int dx = Math.abs(coordinate[0] - row);
            int dy = Math.abs(coordinate[1] - col);
            if(dx == 0 || dy == 0 || dx == dy) return false;
        }
        return true;
    }

    public static void main(String [] args) {
        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(4));
    }
}
