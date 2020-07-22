/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
 * which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 */
public class JumpGame {

//    public boolean canJump(int[] nums) {
//        if(nums == null || nums.length == 0) {
//            return false;
//        }
//        return backtrack(0, nums);
//    }
//
//    public boolean backtrack(int index, int [] nums) {
//        if(index == nums.length -1) return true;
//        int furtherIndex = Math.min(index + nums[index], nums.length -1);
//        System.out.println(furtherIndex);
//        for(int i = index + 1; i<=furtherIndex; i++) {
//            if(backtrack(i, nums)) return true;
//        }
//        return false;
//    }
    public static void main(String [] args) {
        JumpGame jumpGame = new JumpGame();
        int nums[] = {2, 0, 0};
        jumpGame.canJump(nums);
    }

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Status[] dp = new Status[nums.length];
        for(Status status : dp) {
            status = Status.UNKNOWN;
        }
        dp[nums.length-1] = Status.GOOD;
        return backtrack(0, nums, dp);
    }

    public boolean backtrack(int index, int [] nums, Status[] dp) {
        if(dp[index] == Status.GOOD) return true;
        if(dp[index] == Status.BAD) return false;
        int furtherStep = Math.min(index + nums[index], nums.length-1);
        for(int i = furtherStep; i>index; i--) {
            if(backtrack(i, nums, dp)) {
                dp[i] = Status.GOOD;
                return true;
            }
        }
        dp[index] = Status.BAD;
        return false;
    }
}
enum Status {
    GOOD, BAD, UNKNOWN
}