import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of words, each word consists of English lowercase letters.
 *
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to
 * make it equal to word2. For example, "abc" is a predecessor of "abac".
 *
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor
 * of word_2, word_2 is a predecessor of word_3, and so on.
 *
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chain is "a","ba","bda","bdca".
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of English lowercase letters.
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int ans = 1;
        if(words.length == 1) return ans;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int dp[] = new int [words.length];
        Arrays.fill(dp, 1);
        for(int i=words.length-1; i>=0; i--) {
            String temp = words[i];
            for(int j=i-1; j>=0; j--) {
                String preString = words[j];
                if(preString.length() == temp.length()-1) {
                    for(int k=0; k<temp.length(); k++) {
                        String subString = temp.substring(0, k) + temp.substring(k+1);
                        if(subString.equalsIgnoreCase(words[j])) {
                            dp[j] = Math.max(dp[j], dp[i] + 1);
                            ans = Math.max(dp[j], ans);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
