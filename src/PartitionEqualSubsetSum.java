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
        partitionEqualSubsetSum.canPartition(nums);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) {
            sum+=i;
        }
        if(sum % 2 != 0) return false;
        int [][] dp = new int [nums.length+1][sum+1];
        sum = sum/2;
        return recursive(nums, 0, 0, sum, dp);
    }
    private boolean recursive(int [] nums, int index, int cur, int target, int [][] dp) {
        if(cur == target) {
            return true;
        }
        if(index == nums.length || dp[index][cur] == 1) {
            dp[index][cur] = 1;
            return false;
        }
        boolean result = recursive(nums, index + 1, cur + nums[index], target, dp) || recursive(nums, index + 1, cur, target, dp);
        dp[index][cur] = result==true ? 0 : 1;
        return result;
    }

    public boolean canPartitionDP(int[] nums) {
        int sum = 0;
        for(int i: nums) {
            sum+=i;
        }
        if(sum % 2 != 0) return false;
        sum = sum/2;
        int [][] dp = new int [nums.length][sum+1];
        for(int i=0; i<nums.length; i++) {
            dp[i][0] = 1;
        }
        for(int i=0; i<nums.length;i++) {
            for(int j=1; j<=sum;j++) {
                if(nums[i] <= j) {
                    dp[i][j] = dp[i][j-nums[i]];
                }
            }
        }

        return dp[nums.length-1][sum] == 1;
    }
}
