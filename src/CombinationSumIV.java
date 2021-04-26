import java.util.Arrays;

/**
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Example 2:
 *
 * Input: nums = [9], target = 3
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 *
 *
 * Follow up: What if negative numbers are allowed in the given array? How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSumIV {
    //brute force approach
    /*
    int count;
    public int combinationSum4(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }
    public void backtrack(int [] nums, int target, int index, int sum) {
        if(sum == target) {
            count++;
            return;
        }
        if(sum > target || index >= nums.length) {
            return;
        }
        for(int i=0; i<nums.length; i++) {
            backtrack(nums, target, i, sum+nums[i]);
        }
    }
     */

    //Another brute force approach
//    public int combinationSum4(int[] nums, int target) {
//        if(target == 0) {
//            return 1;
//        }
//        int count =0;
//        for(int i: nums) {
//            if(i <= target) {
//                count+= combinationSum4(nums, target - i);
//            }
//        }
//        return count;
//    }

    //backtrack with dp
    public int combinationSum4(int[] nums, int target) {
        int dp [] = new int [target +1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        backtrack(nums, target, dp);
        return dp[target];
    }

    public int backtrack(int [] nums, int target, int [] dp) {
        //why set to -1, because in some case dp[n] could be 0 due to there is no such combination
        // then we have to use (dp[target] > 0)
        //this will increase some duplicate calculation (dp[i] == 0 could be havn't updated as well as 0 combination)
        //not calculated yet
        if(dp[target] > -1) {
            return dp[target];
        }
        int count = 0;
        for(int i: nums) {
            if(i <= target) {
                count += backtrack(nums, target - i, dp);
            }
        }
        dp[target] = count;
        return count;
    }

    //pure dp
    public int combinationSum4PureDP(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
