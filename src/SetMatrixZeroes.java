import javax.print.attribute.SetOfIntegerSyntax;
import java.util.*;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes {
    /**
    //Solution 1 extra space, hash set solution
    public void setZeroesExtraSpace(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for(int i:rowSet) {
            for(int j = 0; j<matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        for(int i:colSet) {
            for(int j = 0; j<matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }
    //Solution 2, space O(1)
    public void setZeroes(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        System.out.println();

        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
**/
    public static void main(String [] args) {
        int [][] test = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(test);
    }
    public static void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j= 0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for(int i=0; i<matrix.length; i++) {
            for(int j= 0; j<matrix[0].length; j++) {
                if(rowSet.contains(i) || colSet.contains(j)) {
                   matrix[i][j] = 0;
                }
            }
        }
    }
}
