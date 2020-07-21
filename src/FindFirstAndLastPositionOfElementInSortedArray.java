/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non decreasing array.
 * -10^9 <= target <= 10^9
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int [2];
        result[0] = -1;
        result[1] = -1;
        if(nums == null || nums.length == 0) return result;
        result[0] = findLeftBoundary(nums, target);
        result[1] = findRightBoundary(nums, target);

        return result;
    }

    public int findLeftBoundary(int[] nums, int target) {
        int index = -1;
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(nums[mid] >= target) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }

    public int findRightBoundary(int[] nums, int target) {
        int index = -1;
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }
}
