/**
 * You are given an array colors, in which there are three colors: 1, 2 and 3.
 *
 * You are also given some queries. Each query consists of two integers i and c,
 * return the shortest distance between the given index i and the target color c. If there is no solution return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
 * Output: [3,0,3]
 * Explanation:
 * The nearest 3 from index 1 is at index 4 (3 steps away).
 * The nearest 2 from index 2 is at index 2 itself (0 steps away).
 * The nearest 1 from index 6 is at index 3 (3 steps away).
 * Example 2:
 *
 * Input: colors = [1,2], queries = [[0,3]]
 * Output: [-1]
 * Explanation: There is no 3 in the array.
 *
 *
 * Constraints:
 *
 * 1 <= colors.length <= 5*10^4
 * 1 <= colors[i] <= 3
 * 1 <= queries.length <= 5*10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] < colors.length
 * 1 <= queries[i][1] <= 3
 */
import java.util.*;
public class ShortestDistanceToTargetColor {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> oneColors = new ArrayList<>();
        List<Integer> twoColors = new ArrayList<>();
        List<Integer> threeColors = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<colors.length;i++) {
            if(colors[i] == 1) {
                oneColors.add(i);
            }
            else if(colors[i] == 2) {
                twoColors.add(i);
            }
            else if(colors[i] == 3) {
                threeColors.add(i);
            }
        }
        for(int [] query : queries) {
            int index = query[0];
            int color = query[1];
            if(colors[index] == color) {
                ans.add(0);
                continue;
            }
            if(color == 1) {
                ans.add(binarySearch(index, oneColors));
            } else if(color == 2) {
                ans.add(binarySearch(index, twoColors));
            } else {
                ans.add(binarySearch(index, threeColors));
            }
        }
        return ans;
    }
    public int binarySearch(int index, List<Integer> list) {
        int left = 0, right = list.size()-1;
        int ans = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int diff = Math.abs(list.get(mid) - index);
            if(diff < ans) {
                ans = diff;
            }
            if(list.get(mid) - index > 0) {
                right = mid-1;
            }else {
                left = mid + 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String []args) {
        int [] test = {1,1,2,1,3,2,2,3,3};
        int [][] queries = {{1,3}, {2,2}, {6,1}};
        ShortestDistanceToTargetColor s = new ShortestDistanceToTargetColor();
        s.shortestDistanceColor(test, queries);
    }
}
