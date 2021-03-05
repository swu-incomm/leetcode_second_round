/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
import java.util.*;
public class MajorityElementii {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> res = new HashSet<>();
        if(nums == null || nums.length < 1) {return new ArrayList(res);}
        int threshold = nums.length/3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if(map.get(nums[i]) > threshold) {
                res.add(nums[i]);
            }
        }
        return new ArrayList<>(res);
    }
}
