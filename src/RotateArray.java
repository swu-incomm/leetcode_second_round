/*
Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

 */
public class RotateArray {
//    public void helper(int [] nums, int l, int r) {
//        while(l < r) {
//            int temp = nums[l];
//            nums[l] = nums[r];
//            nums[r] = temp;
//            l++;r--;
//        }
//    }
//    public void rotate(int[] nums, int k) {
//        if(nums == null || nums.length == 0 || k == 0) return;
//        k = k % nums.length;
//        helper(nums,0,nums.length-1-k);
//        helper(nums,nums.length-k,nums.length-1);
//        helper(nums,0,nums.length-1);
//    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, nums.length-k, nums.length-1);
        reverseArray(nums, 0, nums.length-1-k);
        reverseArray(nums, 0, nums.length-1);
    }
    public void reverseArray(int [] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
