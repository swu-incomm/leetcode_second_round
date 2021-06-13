/**
 There is an integer array nums sorted in ascending order (with distinct values).

 Prior to being passed to your function, nums is rotated at an unknown pivot index
 k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

 Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

 You must write an algorithm with O(log n) runtime complexity.



 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 Example 3:

 Input: nums = [1], target = 0
 Output: -1


 Constraints:

 1 <= nums.length <= 5000
 -104 <= nums[i] <= 104
 All values of nums are unique.
 nums is guaranteed to be rotated at some pivot.
 -104 <= target <= 104
 */

public class SearchInRotatedSortedArray {
//    public int search(int[] nums, int target) {
//        int start = 0;
//        int end = nums.length - 1;
//        while(start <= end) {
//            int mid = start + (end - start)/2;
//            if(nums[mid] == target) return  mid;
//
//            //总有一半的array是有序的 只需要在有序的这一半apply binary search， 否则就交给下一次循环
//            if(nums[start] <= nums[mid]) {
//                if(target < nums[mid] && target >= nums[start]) {
//                    end = mid -1 ;
//                } else {
//                    start = mid + 1;
//                }
//            }
//
//            if(nums[mid] <= nums[end]) {
//                if(nums[mid] < target && target <= nums[end]) {
//                    start = mid + 1;
//                } else {
//                    end = mid -1;
//                }
//            }
//        }
//        return -1;
//    }
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            System.out.println(mid);
            if(target == nums[mid]) return mid;
            //left hand is you xu
            if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                }else {
                     start = mid+1;
                }
            }
            else if(nums[mid] <= nums[end]) {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String [] args) {
        int [] test = {4, 5, 6, 7, 0, 1, 2};
        search(test, 0);
    }
}
