/**
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements.
 * The score you get by erasing the subarray is equal to the sum of its elements.
 *
 * Return the maximum score you can get by erasing exactly one subarray.
 *
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is,
 * if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 * Example 2:
 *
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int [] hashTable = new int [10001];
        int ans = 0, sum = 0;
        int left = 0, right = 0;
        while(right < nums.length) {
            int temp = nums[right];
            if(hashTable[temp] == 0) {
                hashTable[temp] =1;
                sum += temp;
            }
            else {
                while(nums[left] != temp) {
                    hashTable[nums[left]] = 0;
                    sum-=nums[left];
                    left++;
                }
                left++;
            }
            ans = Math.max(ans, sum);
            right++;
        }
        return ans;
    }

    public static void main(String [] args) {
        int [] test = {4,2,4,5,6};
        MaximumErasureValue maximumErasureValue = new MaximumErasureValue();
        maximumErasureValue.maximumUniqueSubarray(test);
    }
}
