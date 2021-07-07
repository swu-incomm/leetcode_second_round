/**
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two
 * whose elements sum up to a multiple of k, or false otherwise.
 *
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 * Example 2:
 *
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 * Example 3:
 *
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 */
import java.util.*;
public class ContinuousSubArraySum {
    //time limited exceeded
    public static boolean checkSubarraySumPrefixSum(int[] nums, int k) {
        int [] prefix = new int [nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for(int i =0; i<prefix.length;i++) {
            for(int j=i; j<prefix.length; j++) {
                if(i == j) continue;
                if(i == 0) {
                    int temp = prefix[j];
                    if(temp %k == 0) {
                        return true;
                    }
                } else {
                    int temp = prefix[j] - prefix[i-1];
                    if(temp % k == 0) return true;
                }
            }
        }
        return false;
    }

    public static void main(String [] args) {
        int [] test = {5, 0, 0, 0, 0};
        System.out.println(checkSubarraySum(test, 2));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            int key = sum % k;
            if(map.containsKey(key)) {
                if(i-map.get(key)>1) {
                    return true;
                }
            }
            map.put(key, i);
        }
        return false;
    }
}
