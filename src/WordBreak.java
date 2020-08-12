
import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {

    // classic dfs solution
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>();
        for (String word : wordDict) {
            dictSet.add(word);
        }
        Map<String, Boolean> cache = new HashMap<>();
        return dfs(s, dictSet, cache);
    }

    public boolean dfs(String s, Set<String> set, Map<String, Boolean> map) {
        if(set.contains(s)) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i = 1; i<s.length(); i++) {
            if(set.contains(s.substring(0, i)) && dfs(s.substring(i, s.length()), set, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    public boolean wordBreakDp(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>();
        for (String word : wordDict) {
            dictSet.add(word);
        }
        boolean [] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i<=s.length(); i++) {
            for(int j = 0; j<i; j++) {
                if(dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
