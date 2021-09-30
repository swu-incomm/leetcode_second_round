/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t
 * (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 *    Hide Hint #1
 * Use two pointers to create a window of letters in S, which would have all the characters from T.
 *    Hide Hint #2
 * Since you have to find the minimum window in S which has all the characters from T, you need to expand and contract the window
 * using the two pointers and keep checking the window for all the characters. This approach is also called Sliding Window Approach.
 *
 * L ------------------------ R , Suppose this is the window that contains all characters of T
 *
 *         L----------------- R , this is the contracted window. We found a smaller window that still contains all the characters in T
 *
 * When the window is no longer valid, start expanding again using the right pointer.
 */
import java.util.*;
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        char [] chars = t.toCharArray();
        for(int i=0; i<chars.length; i++) {
            char temp = chars[i];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int count = map.size();
        int start = 0, end = 0, resLen = Integer.MAX_VALUE;
        String res = "";
        chars = s.toCharArray();
        while(end < s.length()) {
            char charEnd = chars[end++];
            if(map.containsKey(charEnd)) {
                map.put(charEnd, map.get(charEnd) - 1);
                if(map.get(charEnd) == 0) {
                    count--;
                }
            }
            // we don't have an answer yet, need to expand end to the right position
            if(count > 0) continue;

            while(count == 0) {
                char startChar = chars[start++];
                if(map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if(map.get(startChar) > 0) {
                        count++;
                    }
                }
            }
            if(end - start < resLen) {
                resLen = end - start;
                res = s.substring(start-1, end);
            }
        }
        return res;
    }

    public static void main(String [] args) {
        String a = "cabwefgewcwaefgcf";
        String b = "cae";
        System.out.println(minWindow(a, b));
    }
}
