/**
 * You are given a 0-indexed integer array nums and an integer k.
 *
 * You are initially standing at index 0. In one move, you can jump at most k steps forward
 * without going outside the boundaries of the array. That is, you can jump from index i to any index in the range
 * [i + 1, min(n - 1, i + k)] inclusive.
 *
 * You want to reach the last index of the array (index n - 1). Your score is the sum of
 * all nums[j] for each index j you visited in the array.
 *
 * Return the maximum score you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-1,-2,4,-7,3], k = 2
 * Output: 7
 * Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
 * Example 2:
 *
 * Input: nums = [10,-5,-2,4,0,3], k = 3
 * Output: 17
 * Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
 * Example 3:
 *
 * Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * Output: 0
 *
 *
 * Constraints:
 *
 *  1 <= nums.length, k <= 105
 * -104 <= nums[i] <= 104
 */
import java.util.*;
public class JumpGameVI {
//    int ans = Integer.MIN_VALUE;
//    Map<Integer, Integer> map = new HashMap();
//    public int maxResult(int[] nums, int k) {
//        backtrack(nums, k, 0, nums[0]);
//        return ans;
//    }
//    public void backtrack(int [] nums, int k, int index, int cur) {
//        if(index == nums.length - 1) {
//            if(cur > ans) {
//                ans = cur;
//                return;
//            }
//        }
//
//        for(int i = index+1; i<=index + k; i++) {
//          if(i < nums.length) {
//              backtrack(nums, k, i, cur + nums[i]);
//          }
//        }
//    }

    //DP + priority Queue
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int [] dp = new int [nums.length];
        dp[0] = nums[0];
        pq.offer(new int[] {dp[0], 0});
        for(int i= 1; i<nums.length; i++) {
            while(pq.peek()[1] < i - k) {
                pq.poll();
            }
            dp[i] = nums[i] + pq.peek()[0];
            pq.offer(new int []{dp[i], i});
        }
        return dp[nums.length - 1];
    }
}
