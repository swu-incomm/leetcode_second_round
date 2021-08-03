/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word
 * is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
import java.util.*;
public class WordBreakII {
    Set<String> wordSet;
    HashMap<String, List<List<String>>> memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>();
        memo = new HashMap<>();
        for(String word:wordDict) {
            wordSet.add(word);
        }
        backtrack(s);
        List<String> res = new ArrayList<>();
        for(List<String> words : memo.get(s)) {
            StringBuffer sb =new StringBuffer();
            for(String word : words) {
                sb.insert(0, word);
                sb.insert(0, " ");
            }
            res.add(sb.toString().strip());
        }
        return res;
    }

    public List<List<String>> backtrack(String s) {
        if(s.equals("")) {
            List<List<String>> solutions = new ArrayList<>();
            solutions.add(new ArrayList<>());
            return solutions;
        }

        if(memo.containsKey(s)) {
            return memo.get(s);
        } else {
            List<List<String>> solutions = new ArrayList<>();
            memo.put(s, solutions);
        }

        for(int i=1; i<=s.length(); i++) {
            String temp = s.substring(0, i);
            if(wordSet.contains(temp)) {
                List<List<String>> subSentences = backtrack(s.substring(i));
                for(List<String> subSentence : subSentences) {
                    List<String> newSentence = new ArrayList<>(subSentence);
                    newSentence.add(temp);
                    memo.get(s).add(newSentence);
                }
            }
        }
        return memo.get(s);
    }
}
