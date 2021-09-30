/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly
 * in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true
 * if and only if the given words are sorted lexicographically in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
 * lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any
 * other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */
import java.util.*;
public class VerifyAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<order.length(); i++) {
            char temp = order.charAt(i);
            map.put(temp, i);
        }
        for(int i=1; i<words.length; i++) {
            String a = words[i-1];
            String b = words[i];
            for(int j=0; j<b.length();j++) {
                int o2 = map.get(b.charAt(j));
                int o1 = 0;
                if(j < a.length()) {
                    o1 = map.get(a.charAt(j));
                }
                if(o2 < o1) return false;
                if(o1 == o2) {
                    if(j == b.length() -1 && a.length() >b.length()) return false;
                    if(j<b.length()) continue;
                }
                if(o1 < o2) break;
            }
        }
        return true;
    }
}
