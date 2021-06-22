import java.util.HashMap;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 * Each of the array element will not exceed 100.S
 * The array size will not exceed 200.
 *
 *
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {


    public static void main(String [] args) {
        int [] nums = {23,13, 11, 7, 6, 5, 5};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        partitionEqualSubsetSum.canPartitionDP(nums);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(sum %2 != 0) return false;
        sum/=2;
        int [][] dp = new int [nums.length][sum + 1];
        return backtrack(nums, 0, 0, sum, dp) || backtrack(nums, 0, nums[0], sum, dp);
    }

    public boolean backtrack(int [] nums, int index, int cur, int target, int [][]dp) {
        if(cur == target) {
            dp[index][cur] = 1;
            return true;
        }
        if(index == nums.length || cur > target) {
            return false;
        }
        if(dp[index][cur] != 0) {
            return dp[index][cur] == 1 ? true : false;
        }
        boolean res = false;
        for(int i=index + 1; i<nums.length; i++) {
            res = backtrack(nums, i, cur + nums[i], target, dp) || backtrack(nums, i, cur, target, dp);
            if(res) break;
        }
        dp[index][cur] = res ? 1 : -1;
        return res;
    }

    public boolean canPartitionDP(int[] nums) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(sum %2 != 0) return false;
        sum/=2;
        //dp
        boolean [][] dp = new boolean [nums.length][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for(int i =1; i<nums.length; i++) {
            for(int j =0; j<=sum; j++) {
                if(j - nums[i] >= 0) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][sum];
    }
}
