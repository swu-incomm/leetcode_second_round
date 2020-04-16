import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 *
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols,
 * and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 *
 * 解决这道题的方法在于 将paragraph 字符化（toCharArray）， 通过找到非字母字符来找到断点从而生成word， 剩下的就是计算频率了
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {

        //initialization
        paragraph += ".";
        HashSet<String> bannedSet = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int maxFreq = 0;
        String ans = "";
        for(String s : banned) {bannedSet.add(s);}

        StringBuilder stringBuilder = new StringBuilder();

        //processing
        for(char c : paragraph.toCharArray()) {
            if(Character.isLetter(c)) {
                stringBuilder.append(c);
            } else if(stringBuilder.length() > 0) {
                String word = stringBuilder.toString().toLowerCase();
                if(!bannedSet.contains(word)) {
                    //HashMap.getORDefault 用法
                    map.put(word.toLowerCase(), map.getOrDefault(word, 0) + 1);
                    if(map.get(word) > maxFreq) {
                        maxFreq = map.get(word);
                        ans = word;
                    }
                }
                stringBuilder = new StringBuilder();
            }
        }
        return ans;
    }
}
