import java.util.HashMap;

/**
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 *
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 *
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different:
 * for example, if x1 != x1'.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 * Example 2:
 *
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 * Example 3:
 *
 * Input: matrix = [[904]], target = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -
 * -10^8 <= target <= 10^8
 */
public class NumberOfSubmatricesThatSumToTarget {

    public int numSubmatrixSumTargetExtraMemo(int[][] matrix, int target) {
        int len = matrix.length, col = matrix[0].length;
        int [][] acSum = new int [len][col];
        for(int i=0; i<len; i++) {
            acSum[i][0] = matrix[i][0];
        }
        for(int i=0; i<len; i++) {
            for(int j=1; j<col; j++) {
                acSum[i][j] = matrix[i][j] + acSum[i][j-1];
            }
        }
        for(int i=0; i<len; i++) {
            for(int j=0; j<col; j++) {
                System.out.printf("%d ", acSum[i][j]);
            }
            System.out.println();
        }
        int count = 0;
        for(int c1 = 0; c1<col; c1++) {
            for(int c2 = c1; c2<col; c2++) {
                int sum = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);

                for(int i =0; i<len; i++) {
                    sum += acSum[i][c2] - (c1 != 0 ? acSum[i][c1-1] : 0);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
