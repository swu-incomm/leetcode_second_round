import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;
        //ways to sort the original 2d array
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> ans = new ArrayList<>();
        int [] currentInterval = intervals[0];
        int currentBegin = currentInterval[0];
        int currentEnd = currentInterval[1];

        for(int i = 1; i<intervals.length;i++) {
            if(intervals[i][0] <= currentEnd) {
                currentInterval[1] = Math.max(currentEnd, intervals[i][1]);
                currentEnd = currentInterval[1];
            }else {
                ans.add(currentInterval);
                currentInterval = intervals[i];
                currentBegin = currentInterval[0];
                currentEnd = currentInterval[1];
            }
        }

        ans.add(currentInterval);

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String [] args) {
        int [][] test = {
                {1, 4},
                {0, 2},
                {3, 5}
        };
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(test);
    }
}
