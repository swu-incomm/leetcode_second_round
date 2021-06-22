import java.util.Arrays;

/**
 * Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
 *
 * Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ..., nums[ik] with
 * 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence seq is arithmetic if seq[i+1] - seq[i] are
 * all the same value (for 0 <= i < seq.length - 1).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,9,12]i
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 * Example 2:
 *
 * Input: nums = [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 * Example 3:
 *
 * Input: nums = [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 */
public class LonestArithmeticSubsequence {
//    public int longestArithSeqLength(int[] nums) {
//        if(nums.length <=2) return nums.length;
//        int [] dp = new int [nums.length];
//        Arrays.fill(dp, 2);
//        dp[0] = 1;
//        int max = 2;
//        for(int i=2; i<nums.length; i++) {
//            for(int j = i-1; j>0; j--) {
//                for(int k=j-1; k>=0;k--) {
//                    if(nums[j] * 2 - nums[i] == nums[k]) {
//                        dp[j] = Math.max(dp[j], dp[k] + 1);
//                        dp[i] = Math.max(dp[i], dp[j] + 1);
//                        max = Math.max(Math.max(dp[i], dp[j]), max);
//                    }
//                }
//            }
//        }
//        return max;
//    }
    public static void main(String [] args) {
        int [] test = {9, 4, 7, 2, 10};
        LonestArithmeticSubsequence lonestArithmeticSubsequence = new LonestArithmeticSubsequence();
        lonestArithmeticSubsequence.longestArithSeqLength(test);
    }

    /**
     * Constraints:
     *
     * 2 <= nums.length <= 1000
     * 0 <= nums[i] <= 500
     */
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int [][] dp = new int [n][n];
        int [] index = new int [20001];
        Arrays.fill(index, -1);
        int max=  2;
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], 2);
            for(int j=i+1; j<n;j++) {
                int temp = nums[i] * 2 - nums[j];
                if(temp < 0 || index[temp] == -1) continue;
                dp[i][j] = dp[index[temp]][i] + 1;
                max = Math.max(max, dp[i][j]);
            }
            //put i's index into use, so that in the future
            // nums[i] was calculated as the first element, we can quickly find the index of nums[i]
            index[nums[i]] = i;
        }
        return max;
    }
}
