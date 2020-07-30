/**
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ans = nums[0];
        int [] dpMax = new int[nums.length];
        int [] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for(int i = 1; i<nums.length; i++) {
            dpMax[i] = Math.max(Math.max(nums[i] * dpMax[i-1], nums[i] * dpMin[i-1]), nums[i]);
            dpMin[i] = Math.min(Math.min(nums[i] * dpMin[i-1], nums[i] * dpMax[i-1]), nums[i]);
            ans = Math.max(dpMax[i] , ans);
        }
        return ans;
    }
}
