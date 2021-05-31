import java.util.*;

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
        int currentEnd = currentInterval[1];

        for(int i = 1; i<intervals.length;i++) {
            if(intervals[i][0] <= currentEnd) {
                currentInterval[1] = Math.max(currentEnd, intervals[i][1]);
                currentEnd = currentInterval[1];
            }else {
                ans.add(currentInterval);
                currentInterval = intervals[i];
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

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> newIntervals = new ArrayList<>();
        for(int [] interval : intervals) {
            newIntervals.add(interval);
        }
        newIntervals.add(newInterval);
        Collections.sort(newIntervals, (a, b)->a[0] - b[0]);
        List<int []> ans = new ArrayList<>();
        int [] cur = newIntervals.get(0);
        int curEnd = cur[1];
        for(int i=1; i<newIntervals.size();i++) {
            int [] temp = newIntervals.get(i);
            if(temp[0] <= curEnd) {
                curEnd = Math.max(curEnd, temp[1]);
                cur[1] = curEnd;
            } else {
                ans.add(cur);
                cur = temp;
                curEnd = temp[1];
                continue;
            }
        }
        ans.add(cur);
        return ans.toArray(new int [ans.size()][]);
    }
}
