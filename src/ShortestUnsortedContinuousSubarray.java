import java.util.Arrays;

/**
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 0
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 *
 * Follow up: Can you solve it in O(n) time complexity?
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int [] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int lp = nums.length-1, rp = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != sortedNums[i]) {
                lp = Math.min(i,lp);
                rp = Math.max(rp, i);
            }
        }
        return rp- lp + 1;
    }
}
