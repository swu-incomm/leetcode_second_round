import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int temp = nums.length-2;
        while(temp >= 0 && nums[temp] >= nums[temp+1]) {
            temp--;
        }
        //from right to left it is increasing sequence
        if(temp >= 0) {
            int j = nums.length-1;
            while(nums[j] <= nums[temp]) {
                j--;
            }

            swap(nums, j, temp);
        }
        reverse(nums, temp +1, nums.length-1 );
    }

    public void swap(int [] nums, int x, int y) {
        int temp = nums[x];
        nums[x]= nums[y];
        nums[y] = temp;
    }

    public void reverse(int [] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String [] args) {
        NextPermutation np = new NextPermutation();
        int [] test = new int []{5, 1, 1};
        //int [] test = new int []{1, 2, 3};
        np.nextPermutation(test);
        Arrays.stream(test).forEach(System.out::println);
    }
}
