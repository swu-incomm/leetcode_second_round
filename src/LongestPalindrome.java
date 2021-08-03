/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest
 * palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Example 3:
 *
 * Input: s = "bb"
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */
public class LongestPalindrome {
    //palindrome will
    public int longestPalindrome(String s) {
        int [] count = new int [128];
        for(char ch : s.toCharArray()) {
            count[ch]++;
        }
        int res = 0;
        for(int i : count) {
            res += i/2 *2;
            if(res % 2 == 0 && i%2 == 1) res++;
        }
        return res;
    }
}
