/**
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Accepted
 */
import java.util.*;
public class _4Sum {
    List<List<Integer>> res;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        res = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                threeSum(i + 1, nums[i], target, nums);
            }
        }
        return res;
    }
    //-2,-1,-1,1,1,2,2
    public void threeSum(int start, int cur, int target, int [] nums) {
        target -= cur;
        for(int i=start; i<nums.length-2; i++) {
            if(i == start || nums[i] != nums[i-1]) {
                int left = i +1;
                int right = nums.length-1;
                while(left < right) {
                    int temp = nums[left] + nums[right];
                    if(temp + nums[i] == target) {
                        ArrayList<Integer> subAns = new ArrayList<>();
                        subAns.add(cur);
                        subAns.add(nums[i]);
                        subAns.add(nums[left]);
                        subAns.add(nums[right]);
                        this.res.add(subAns);
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(right > left && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if(temp + nums[i]< target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
    }

    public static void main(String [] args) {
        int [] test = {-2,-1,-1,1,1,2,2};
        _4Sum fourSum = new _4Sum();
        List<List<Integer>> ans = fourSum.fourSum(test, 0);
        for(List<Integer> list : ans) {
            for(int a : list) {
                System.out.printf("%d ", a);
            }
            System.out.println();
        }
    }
}
