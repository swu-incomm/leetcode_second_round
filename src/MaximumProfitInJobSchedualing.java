import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining
 * a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that
 * there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * Example 2:
 *
 *
 *
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job.
 * Profit obtained 150 = 20 + 70 + 60.
 * Example 3:
 *
 *
 *
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= startTime.length == endTime.length == profit.length <= 5 * 104
 * 1 <= startTime[i] < endTime[i] <= 109
 * 1 <= profit[i] <= 104
 */
public class MaximumProfitInJobSchedualing {
    class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job [] jobs = new Job [n];
        for(int i=0; i<n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Comparator<Job> comp = Comparator.comparingInt(a -> a.end);
        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        //dp process
        //两种不同的定义方式
        //第一种 dp[i] 表示第i份工作一定做的情况下 最大profit 需要n^2
        //第二种 dp[i] 表示在i这个时间点上 最大profit 为单调递增 所以找到第一个j后可以break
        int [] dp = new int [n];
        dp[0] = jobs[0].profit;
        for(int i=1; i<n; i++) {
            //we don't take this job
            dp[i] = dp[i-1];
            //we take this job
            //一定单调递增 所以从后往前遍历
            for(int j=i-1;j>=0;j--) {
                if(jobs[j].end <= jobs[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i].profit);
                    break;
                }
            }
            //just in case we don't find preceders job
            dp[i] = Math.max(dp[i], jobs[i].profit);
        }
        return dp[n-1];
    }

    public int jobSchedulingDp2(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int [] dp = new int [n];
        Job [] jobs = new Job [n];
        for(int i=0; i<n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Comparator<Job> comp = Comparator.comparingInt(a -> a.end);
        Arrays.sort(jobs, comp);

        for(int i=0; i<n; i++) {
            dp[i] = jobs[i].profit;
        }

        //dp process
        //第一种 dp[i] 表示第i份工作一定做的情况下 最大profit 需要n^2
        int max = dp[0];
        for(int i=1; i<n; i++) {
            for(int j=0;j<i;j++) {
                if(jobs[j].end <= jobs[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i].profit);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String [] args) {

    }
}
