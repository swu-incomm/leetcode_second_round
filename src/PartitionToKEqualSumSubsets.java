/**
 * Given an integer array nums and an integer k, return true if it is possible to divide this array
 * into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Example 2:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 16
 * 1 <= nums[i] <= 104
 * The frequency of each element is in the range [1, 4].
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i:nums) sum+=i;
        if(sum % k != 0) return false;
        boolean[] used = new boolean[nums.length];
        sum/=k;
        return backtrack(nums, used, 0,0, sum, k);
    }
    public boolean backtrack(int [] nums, boolean [] used, int index, int curSum, int targetSum, int remainingK) {
        if(remainingK == 1) {
            return true;
        }
        if(index == nums.length || curSum > targetSum) {
            return false;
        }
        if(curSum == targetSum) {
            return backtrack(nums,  used, 0, 0, targetSum, remainingK-1);
        }
        for(int i=index; i<nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                if(backtrack(nums,  used, i + 1, curSum + nums[i], targetSum, remainingK)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
