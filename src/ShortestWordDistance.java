/**
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2,
 * return the shortest distance between these two words in the list.
 *
 *
 *
 * Example 1:
 *
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * Output: 3
 * Example 2:
 *
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= wordsDict.length <= 3 * 104
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] consists of lowercase English letters.
 * word1 and word2 are in wordsDict.
 * word1 != word2
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int pWord1 = -1, pWord2 = -1;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<wordsDict.length; i++) {
            if(wordsDict[i].equalsIgnoreCase(word1)) {
                pWord1 = i;
            }
            if(wordsDict[i].equalsIgnoreCase(word2)) {
                pWord2 = i;
            }
            if(pWord1 != -1 && pWord2 != -1) {
                ans = Math.min(ans, Math.abs(pWord1 - pWord2));
            }
        }
        return ans;
    }
}
