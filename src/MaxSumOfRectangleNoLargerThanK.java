import java.util.TreeSet;

/**
 * Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
 *
 * It is guaranteed that there will be a rectangle with a sum no larger than k.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
 * Example 2:
 *
 * Input: matrix = [[2,2,-1]], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 *
 *
 * Follow up: What if the number of rows is much larger than the number of columns?
 */
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i<m; i++) {
            int [] temp = new int [n];
            for(int j= i; j<m; j++) {
                for(int col = 0; col < n; col++) {
                    temp[col] += matrix[j][col];
                }
                res = Math.max(res, maxSumArray(temp, k));
            }
        }
        return res;
    }

    //sub problem in one dimension array
    //TreeSet is the data structure help to find one element's ceiling or flooring element in log(n) time
    public int maxSumArray(int [] arr, int k) {
        int sum = 0, res = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for(int i=0; i<arr.length; i++) {
            sum+=arr[i];
            Integer remain = set.ceiling(sum - k);
            if(remain != null) {
                res = Math.max(res, sum - remain);
            }
            set.add(sum);
        }
        return res;
    }

    public static void main(String [] args) {
        int [][] test = {{2,2,-1}};
        MaxSumOfRectangleNoLargerThanK m = new MaxSumOfRectangleNoLargerThanK();
        m.maxSumSubmatrix(test, 0);
    }
}
