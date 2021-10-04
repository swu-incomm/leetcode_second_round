import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array)
 * fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of
 * space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length <= 1) return new int[0];

        int [] ans = new int [nums.length];
        ans[0] = 1;
        for(int i = 1; i<nums.length;i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int temp = 1;
        for(int i =nums.length-1; i>=0;i--) {
            ans[i] *= temp;
            temp*=nums[i];
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        int [] left = new int [nums.length];
        int [] right = new int [nums.length];
        left[0] = nums[0];
        right[nums.length-1] = nums[nums.length-1];
        for(int i=1; i<nums.length;i++) {
            left[i] = nums[i] * left[i-1];
        }
        for(int i=nums.length-2; i>=0;i--) {
            right[i] = nums[i] * right[i+1];
        }
        nums[0] = right[1];
        nums[nums.length-1] = left[nums.length-2];
        for(int i=1; i<nums.length-1; i++) {
           nums[i] = left[i-1] * right[i+1];
        }
        return nums;
    }
}
