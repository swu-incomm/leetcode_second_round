/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * The solution set must not contain duplicate combinations.
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Example 3:
 *
 * Input: k = 4, n = 1
 * Output: []
 * Example 4:
 *
 * Input: k = 3, n = 2
 * Output: []
 * Example 5:
 *
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 *
 *
 * Constraints:
 *
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
import java.util.*;
public class CombinationSumiii {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(k, n, 1, 0, ans, new ArrayList<>());
        return ans;
    }

    public void backtrack(int k, int n, int index, int cur, List<List<Integer>> ans, List<Integer> subList) {
        if(cur == n && subList.size() == k) {
            ans.add(new ArrayList(subList));
            return;
        }
        for(int i=index; i<=9; i++) {
            subList.add(i);
            backtrack(k, n, i+1, cur + i, ans, subList);
            subList.remove(subList.size()-1);
        }
    }

    public static void main(String [] args) {
        CombinationSumiii combinationSumiii = new CombinationSumiii();
        combinationSumiii.combinationSum3(9, 45);
    }
}
