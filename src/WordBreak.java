
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
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class WordBreak {
    //First solution top-down backtrack with memorization
    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(0, s, wordDict, new Boolean[s.length()]);
    }

    public boolean backtrack(int index, String s, List<String> wordDict, Boolean [] memorization) {
        if(index == s.length()) {
            return true;
        }
        if(memorization[index] != null) {
            return memorization[index];
        }
        boolean res = false;
        for(int i=index +1; i<=s.length(); i++) {
            if(wordDict.contains(s.substring(index, i)) && backtrack(i, s, wordDict, memorization)) {
                res = true;
                break;
            }
        }
        memorization[index] = res;
        return res;
    }

    //Second solution bottom up dp
    public boolean wordBreakDpBottomUp(String s, List<String> wordDict) {
        boolean [] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<wordDict.size(); j++) {
                String temp = wordDict.get(j);
                int diff = i - temp.length();
                if(diff >= 0 && dp[diff]) {
                    dp[i] = s.substring(diff, i).equals(temp);
                }
            }
        }
        return dp[s.length()];
    }
}
