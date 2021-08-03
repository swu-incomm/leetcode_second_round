/**
 * Given an integer array nums which is sorted in ascending order and all of its elements
 * are unique and given also an integer k, return the kth missing number starting from the leftmost number of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,7,9,10], k = 1
 * Output: 5
 * Explanation: The first missing number is 5.
 * Example 2:
 *
 * Input: nums = [4,7,9,10], k = 3
 * Output: 8
 * Explanation: The missing numbers are [5,6,8,...], hence the third missing number is 8.
 * Example 3:
 *
 * Input: nums = [1,2,4], k = 3
 * Output: 6
 * Explanation: The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * 1 <= nums[i] <= 107
 * nums is sorted in ascending order, and all the elements are unique.
 * 1 <= k <= 108
 *
 *
 * Follow up: Can you find a logarithmic time complexity (i.e., O(log(n))) solution?
 */
public class MissingElementInSortedArray {
    public int calculateMissing(int [] nums, int index){
        return nums[index] - nums[0] - index;
    }
    //O(n)
    public int missingElement(int[] nums, int k) {
        if(calculateMissing(nums, nums.length-1) < k) return nums[nums.length-1] + k - calculateMissing(nums, nums.length-1);
        int res = 0;
        while(calculateMissing(nums, res) < k) res++;
        return nums[res -1] + k - calculateMissing(nums, res -1);
    }

    public int missingElementBinarySearch(int[] nums, int k) {
        if(calculateMissing(nums, nums.length-1) < k) return nums[nums.length-1] + k - calculateMissing(nums, nums.length-1);
        int start = 0, end = nums.length -1;
        int res = 0;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(calculateMissing(nums, mid) <k && calculateMissing(nums, mid + 1) >=k) {
                res = nums[mid] + k - calculateMissing(nums, mid + 1);
                break;
            }
            else if(calculateMissing(nums, mid) > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
