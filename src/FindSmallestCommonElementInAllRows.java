import java.util.*;
import java.util.Map.*;
/**
 * Given a matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.
 *
 * If there is no common element, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= mat.length, mat[i].length <= 500
 * 1 <= mat[i][j] <= 10^4
 * mat[i] is sorted in strictly increasing order.
 */
public class FindSmallestCommonElementInAllRows {
    public int smallestCommonElement(int[][] mat) {
        if(mat == null || mat.length == 0 || mat[0].length == 0) return -1;
        int [] hashTable = new int [10001];
        int m = mat.length;
        int n = mat[0].length;
        for(int i =0; i<m; i++) {
            for(int j=0; j< n; j++) {
                int cur = mat[i][j];
                hashTable[cur]++;
            }
        }
        for(int i=1; i<=10000; i++) {
            if(hashTable[i] == m) {
                return i;
            }
        }
        return -1;
    }
}
