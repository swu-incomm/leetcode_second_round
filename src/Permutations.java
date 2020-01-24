import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        backtrack(res, new ArrayList<Integer>(), nums);
        return res;
    }

    public void backtrack(List<List<Integer>>res, List<Integer> cur, int [] nums) {
        if(cur.size() == nums.length) {
            System.out.println(cur);
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(!cur.contains(nums[i])) {
                cur.add(nums[i]);
                backtrack(res, cur, nums);
                cur.remove(cur.size()-1);
            }
        }
    }
    public static void main(String [] args) {
        int [] test = new int [] {
          1, 2, 3
        };
        Permutations permutations = new Permutations();
        permutations.permute(test);
    }
}
