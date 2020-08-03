import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        //we either take out first one or last one
        int r[] = new int [nums.length];
        int nr[] = new int[nums.length];

        //first iteration, rob house 1, then we take out the last one, loop through 0->nums.length-2
        r[0] = nums[0];
        for(int i = 1; i<nums.length-1;i++) {
            r[i] = nr[i-1] + nums[i];
            nr[i] = Math.max(nr[i-1], r[i-1]);
        }

        int ans = Math.max(r[nums.length-2], nr[nums.length-2]);

        //second iteration we don't include house index 0

        Arrays.fill(r, 0);
        Arrays.fill(nr, 0);
        r[1] = nums[1];
        nr[1] = 0;

        for(int i = 2; i<nums.length; i++) {
            r[i] = nr[i-1] + nums[i];
            nr[i] = Math.max(nr[i-1], r[i-1]);
        }

        ans = Math.max(Math.max(r[nums.length-1], nr[nums.length-1]), ans);
        return ans;

    }
}
