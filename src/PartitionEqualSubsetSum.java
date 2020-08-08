/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 * Each of the array element will not exceed 100.
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
 */
public class PartitionEqualSubsetSum {
    //classic knapSack 0/1 problem
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1) return false;
        int sum = 0;
        for(int i : nums) sum+=i;
        if(sum % 2 != 0) return false;
        return knapSack(nums, sum/2);
    }

    public boolean knapSack(int [] nums, int target) {
        boolean [][] dp = new boolean [nums.length][target + 1];
        //预处理很重要
        for(int i = 0; i<=target; i++) { if(nums[0] == i) dp[0][i] = true; }
        for(int i =0; i<nums.length; i++) { dp[i][0] = true; }
        for(int i = 1; i <nums.length; i++) {
            for(int j = 1; j<=target; j++) {
                if(nums[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j - nums[i]] || dp[i-1][j];
                }
            }
        }
//        for(int i = 0; i <nums.length; i++) {
//            for(int j = 0; j<=target; j++) {
//                System.out.printf("%d ", dp[i][j] ? 1 : 0);
//            }
//            System.out.println();
//        }
        return dp[nums.length-1][target];
    }

    public static void main(String [] args) {
        int [] nums = {23,13, 11, 7, 6, 5, 5};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        partitionEqualSubsetSum.canPartition(nums);
    }
}
