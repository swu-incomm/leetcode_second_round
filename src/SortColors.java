import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
 * then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {
    public void sortColorsTwoPass(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int z = 0;
        int o = 0;
        int t = 0;
        for(int i = 0; i<nums.length;i++) {
            if(nums[i] == 0) z++;
            else if(nums[i] == 1) o++;
            else {
                t++;
            }
        }
        for(int i = 0; i<nums.length;i++) {
            if(i<z) nums[i] = 0;
            else if(i<z+o) nums[i] = 1;
            else {
                nums[i] = 2;
            }
        }
    }

    //one pass solution
    //we keep 2 pointers l and r for tracking the most inner 0 and 2's
    //index pointer will be the pointer to traverse the array
    //if nums[index] == 0, swap(nums[l], nums[index]) l++, index++;(only possible to bring 0's when front is all 0s before index or 1 when 1's
    // current place is where the next 0 should be)
    //if nums[index] == 2, swap(nums[r], nums[index]), r--, index remain
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int l = 0, r = nums.length -1;
        int index = 0;
        while(index <= r) {
            if(nums[index] == 0) {
                System.out.println("been here");
                nums[index] = nums[l];
                nums[l] = 0;
                l++;
                index++;
            } else if(nums[index] == 2) {
                nums[index] = nums[r];
                nums[r] = 2;
                r--;
            } else {
                index ++;
            }
        }
    }
    public static void main(String [] args) {
        int [] test = {2, 0, 1};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(test);
        //for(int i:test) {System.out.printf("%d ", i);}
    }
}
