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
    //Back tracking: time limit exceed
    /**
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 1) return false;
        return backtrack(0, nums);
    }

    public boolean backtrack(int index, int [] nums) {
        if(index == nums.length - 1) return true;
        int maximumOffset = index + nums[index];
        for(int i=index+1; i<=maximumOffset; i++) {
            if(i<nums.length) {
                if(backtrack(i, nums)) {
                    return true;
                }
            }
        }
        return false;
    }**/
    //dynamic programming like backtracking but with memo
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 1) return false;
        Status statuses [] = new Status [nums.length];
        for(int i=0; i<statuses.length; i++) {
            statuses[i] = Status.UNKNOWN;
        }
        return backtrack(0, nums, statuses);
    }

    public boolean backtrack(int index, int [] nums, Status [] statuses) {
        if(index == nums.length - 1) return true;
        if(statuses[index].equals(Status.BAD)) return false;
        int maximumOffset = index + nums[index];
        for(int i=index+1; i<=maximumOffset; i++) {
            if(i<nums.length) {
                if(backtrack(i, nums, statuses)) {
                    return true;
                }
            }
        }
        statuses[index] = Status.BAD;
        return false;
    }
    public static void main( String [] args) {
        int [] test = new int [] {2, 0, 0};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(test));
    }
}
enum Status {
    BAD, UNKNOWN
}