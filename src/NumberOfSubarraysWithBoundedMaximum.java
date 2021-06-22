/**
 * We are given an array nums of positive integers, and two positive integers left and right (left <= right).
 *
 * Return the number of (contiguous, non-empty) subarrays such that the value of the
 * maximum array element in that subarray is at least left and at most right.
 *
 * Example:
 * Input:
 * nums = [2, 1, 4, 3]
 * left = 2
 * right = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 * Note:
 *
 * left, right, and nums[i] will be an integer in the range [0, 109].
 * The length of nums will be in the range of [1, 50000].
 */
public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start=-1, end = -1, res = 0;
        for(int i=0; i<nums.length;i++) {
            if(nums[i] > right) {
                start = i;
                end = i;
                continue;
            }
            if(nums[i] >= left) {
               end = i;
            }
            res += end - start;
        }
        return res;
    }
    //every time the res will plus the number of subarrays ending at current i
    //0 1 2 3 4 5 6 7 8 9 10
    //1 2 4 3 4 0 6 1 2 4 3
    //L=4 R=5
}
