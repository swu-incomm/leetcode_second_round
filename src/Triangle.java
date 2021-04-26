/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i
 * on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 * Constraints:
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 *
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 *
 */
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++) {
            List<Integer> subList = triangle.get(i);
            for(int j=0; j<subList.size(); j++) {
                int lastSize = triangle.get(i-1).size();
                int temp1 = j -1 > 0 ? triangle.get(i-1).get(j-1) : Integer.MAX_VALUE;
                int temp2 = j < lastSize ? triangle.get(i-1).get(j) : Integer.MAX_VALUE;
                subList.set(j, Math.min(temp1, temp2) + subList.get(j));
            }
        }
        List<Integer> lastRow = triangle.get(triangle.size()-1);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<lastRow.size(); i++) {
            min = Math.min(min, lastRow.get(i));
        }
        return min;
    }
}
