/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/
public class MoveZeroes {

    //solution one: fill the array with all non-zero values and then fill the other places as zeroes
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for(int i = j; i <nums.length; i++) nums[i] = 0;
    }

    //j always point to the first begining of the zeroes
    public void moveZeroesSwithch(int[] nums) {
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

    }
}
