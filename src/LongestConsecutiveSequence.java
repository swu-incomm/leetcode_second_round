import java.util.Arrays;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
import java.util.*;
public class LongestConsecutiveSequence {
//    public int longestConsecutive(int[] nums) {
//        HashSet<Integer> set= new HashSet<>();
//        for(int i: nums) {
//          set.add(i);
//        }
//        int []nums2 = new int[set.size()];
//        int i=0;
//        for(int val: set) {
//            nums2[i++] = val;
//        }
//        if(nums2.length == 1) return 1;
//        Arrays.sort(nums2);
//        int left = 0, right = 0;
//        int ans = 0;
//        while(right < nums2.length-1) {
//            while(right < nums2.length-1 && nums2[right] == nums2[right+1] - 1) {
//                right ++;
//            }
//            int len = right - left + 1;
//            ans = Math.max(len, ans);
//            right++;
//            left = right;
//        }
//        return ans;
//    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums) {
            set.add(i);
        }
        int [] numsCopy = new int [set.size()];
        int j= 0;
        for(int i : set) {
            numsCopy[j++] = i;
        }
        if(numsCopy.length == 1) return 1;
        Arrays.sort(numsCopy);
        int left = 0, right = 0;
        int ans = 0;
        while(right < numsCopy.length-1) {
            while(right < numsCopy.length - 1 && numsCopy[right] == numsCopy[right + 1] - 1) {
                right++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
            left = right;
        }
        return ans;
    }

    public static void main(String [] args) {
        //int [] test = {0,3,7,2,5,8,4,6,0,1};
        int [] test = {1,2,0,1};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(test));
    }

    public int longestConsecutiveNiubi(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums) {
            set.add(i);
        }
        int ans = 0;
        for(int i : set) {
            if(!set.contains(i-1)) {
                int num = i;
                int currentStreak = 1;
                while(set.contains(num+1)) {
                    currentStreak++;
                    num++;
                }
                ans = Math.max(ans, currentStreak);
            }
        }
        return ans;
    }
}
