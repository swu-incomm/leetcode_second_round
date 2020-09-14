import java.util.*;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> list = new ArrayList<>();
        for(int i = 0; i<intervals.length; i++) list.add(intervals[i]);
        list.add(newInterval);
        Collections.sort(list, Comparator.comparingInt(arr -> arr[0]));
        List<int []> ans = new ArrayList<>();
        int [] currentInterval = list.get(0);
        int curEnd = currentInterval[1];
        for(int i= 1; i<list.size(); i++) {
            int [] tempInterval = list.get(i);
            if(tempInterval[0] <= curEnd) {
                currentInterval[1] = Math.max(curEnd, tempInterval[1]);
                curEnd = currentInterval[1];
            } else {
                ans.add(currentInterval);
                currentInterval = tempInterval;
                curEnd=tempInterval[1];
            }
        }
        ans.add(currentInterval);
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String [] args) {
        int [][] test = { {1,2},{3,5}, {6,7},{8,10},{12,16}};
        int [] interval = {4, 8};
        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(test, interval);
    }
}
