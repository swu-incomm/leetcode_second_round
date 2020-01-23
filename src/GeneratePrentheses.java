import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GeneratePrentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", n, res, 0, 0);
        return res;
    }

    private void backtrack(String cur, int n, List<String> res, int open, int close) {
        if(cur.length() == n * 2) {
            res.add(cur);
            return;
        }
        if(open < n) {
            backtrack(cur + "(", n, res, open + 1, close);
        }
        if(close < open) {
            backtrack(cur + ")", n, res, open, close + 1);
        }
    }
}
