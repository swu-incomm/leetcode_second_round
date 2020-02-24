
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        backtrack(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> subList, int index, int[] nums) {
        if(subList.size() <= nums.length) {
            res.add(new ArrayList<>(subList));
        }
        for(int i=index;i<nums.length;i++) {
            subList.add(nums[i]);
            backtrack(res, subList, i+1, nums);
            subList.remove(subList.size()-1);
        }
    }
    public static void main(String [] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(new int []{1,2,3,4});
        Stream.of(result.toString())
                .forEach(System.out::println);
    }
}
