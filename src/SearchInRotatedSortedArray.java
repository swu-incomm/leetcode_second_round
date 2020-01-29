/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * the idea of the solution will be , after you find the mid, there must be on half of the array that is still ordered. we will begin our search in that part.
 * every time we are only using the binary search in the ordered part of the array, otherwise it's gonna be in the other part, then we will be using another iteration to proceed
 */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return  mid;

            //总有一半的array是有序的 只需要在有序的这一半apply binary search， 否则就交给下一次循环
            if(nums[start] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[start]) {
                    end = mid -1 ;
                } else {
                    start = mid + 1;
                }
            }

            if(nums[mid] <= nums[end]) {
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}
