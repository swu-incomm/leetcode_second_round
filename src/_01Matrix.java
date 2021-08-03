/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */
import java.util.*;
public class _01Matrix {
    int [][] directions = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<int []> queue = new LinkedList<>();
        for(int i=0; i<row;i++) {
            for(int j = 0; j<col; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int [] {i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int [] temp = queue.poll();
                for(int [] direction : directions) {
                    int x = direction[0] + temp[0];
                    int y = direction[1] + temp[1];
                    if(x >=0 && x < row && y >=0 && y < col && mat[x][y] > mat[temp[0]][temp[1]]) {
                        mat[x][y] = 1 + mat[temp[0]][temp[1]];
                        queue.offer(new int [] {x, y});
                    }
                }
            }
        }
        return mat;
    }
}
