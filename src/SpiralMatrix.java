import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 很简单的模拟题  定好四个方向的数组 设置好拐点条件
 */
public class SpiralMatrix {
    int [] dr = {0, 1, 0, -1};
    int [] dc = {1, 0, -1, 0};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return ans;
        int r = matrix.length;
        int c = matrix[0].length;

        int vr = 0, vc = 0, p = 0;
        int [][] visited = new int [r][c];
        for(int i = 0; i<r * c; i++) {
            ans.add(matrix[vr][vc]);
            visited[vr][vc] = 1;
            int temp1 = vr + dr[p];
            int temp2 = vc + dc[p];
            if(temp1 < 0 || temp1 > matrix.length -1 || temp2 <0 || temp2 > matrix[0].length-1 || visited[temp1][temp2] == 1) {
                p = (p + 1) % 4;
                vr += dr[p];
                vc += dc[p];
                continue;
            }
            vr = temp1;
            vc = temp2;
        }
        return ans;
    }

    public static void main(String [] args) {
        int[][] test = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(test).stream().forEach(System.out::println);
    }

    /**
     * Constraints:
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int size = matrix.length * matrix[0].length;
        int top = 0;
        int left = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        while(ans.size() < size) {
            for(int i = left; i<=right && ans.size() < size; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bottom && ans.size() < size; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            for(int i=right; i>=left && ans.size() < size; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i=bottom; i>=top && ans.size() < size; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
