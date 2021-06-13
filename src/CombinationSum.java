import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * Each element of candidate is unique.
 * 1 <= target <= 500
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return ans;

        backtrack(candidates, 0, ans, new ArrayList<>(), target);
        return ans;
    }

    private void backtrack(int [] candidates, int pos, List<List<Integer>> ans, List<Integer> subList, int target) {
        int sum = subList.stream().mapToInt(Integer::valueOf).sum();
        if(sum == target) {
            ans.add(new ArrayList<>(subList));
        } else if(sum > target) return;
        for(int i = pos; i<candidates.length;i++) {
            subList.add(candidates[i]);
            backtrack(candidates, i, ans, subList, target);
            subList.remove(subList.size()-1);
        }
    }
}
