/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        if(nums == null || nums.length == 0) return ans;
        for(int i : nums) {
            ans ^= i;
        }
        return ans;
    }
    public static void main(String [] args) {
        SingleNumber singleNumber = new SingleNumber();
        int [] test = new int [] {2, 2, 1, 1, 10};
        System.out.println(singleNumber.singleNumber(test));
    }
}
