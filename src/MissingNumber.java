import java.util.Arrays;
import java.util.HashSet;

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    //solution 1: Gao si Formular
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) /2;
        int actualSum = Arrays.stream(nums).reduce(0, (a, b) -> a+b);
        return sum - actualSum;
    }

    public int missingNumberHashSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums) {
            hashSet.add(i);
        }
        for(int i = 0; i<=nums.length; i++) {
            if(!hashSet.contains(i)) return i;
        }
        return -1;
    }
}
