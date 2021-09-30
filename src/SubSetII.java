/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
import java.util.*;
public class SubSetII {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int [] nums, int index, List<Integer> list) {
        res.add(new ArrayList<>(list));
        if(index == nums.length) {
            return;
        }
        for(int i=index; i<nums.length; i++) {
            if(i == index || nums[i] != nums[i-1]) {
                list.add(nums[i]);
                backtrack(nums, i + 1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
