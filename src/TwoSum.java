/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int [2] ;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
            }
        }
        return ans;
    }
    public static void main(String [] args) {
        int [] nums = new int []{2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        int []ans = twoSum.twoSum(nums, 9);
        Arrays.stream(ans).forEach(s -> System.out.println(s));
    }

}
