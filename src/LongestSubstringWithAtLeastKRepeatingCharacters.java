/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that
 * every character in T appears no less than k times.
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0 || s.length() < k) return 0;
        int ans = s.length();
        int [] hash = new int [26];
        for(int i = 0; i<s.length(); i++) {
            hash[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i<s.length(); i++) {
            if(hash[s.charAt(i) - 'a'] >= k) {continue;}
            int j = i + 1;
            while(j<s.length() && hash[s.charAt(j) - 'a'] < k) j++;
            return Math.max(longestSubstring(s.substring(0, i), k),longestSubstring(s.substring(j), k));
        }
        return ans;
    }
}
