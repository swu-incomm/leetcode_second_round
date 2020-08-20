import java.util.Arrays;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 *
 * Input: [5,4,3,2,1]
 * Output: false
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        int [] dp = new int [nums.length];
        Arrays.fill(dp, 1);
        for(int i =0; i<nums.length; i++) {
            for(int j = 0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] == 3) return true;
        }
        return false;
    }
}
