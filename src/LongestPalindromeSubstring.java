/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i=0 ;i<s.length(); i++) {
            String temp1 = findPalindrome(s, i, i);
            String temp2 = findPalindrome(s, i, i + 1);
            String temp = temp1.length() > temp2.length() ? temp1 : temp2;
            if(temp.length() > res.length()) {
                res = temp;
            }
        }
        return res;
    }
    public String findPalindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i) != s.charAt(j)) {
                return s.substring(i+1, j);
            }
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
