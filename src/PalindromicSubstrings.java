/**
 * Share
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist
 * of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Note:
 *
 * The input string length won't exceed 1000.
 * 这道题可以用和longest palindrome 相似的解法
 */
public class PalindromicSubstrings {
//    int ans = 0;
//    public int countSubstrings(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            extendPalindrome(s, i, i);
//            extendPalindrome(s, i, i + 1);
//        }
//        return ans;
//    }
//
//    public void extendPalindrome(String s, int i, int j) {
//        while(i >=0 && j <s.length() && s.charAt(i) == s.charAt(j)) {
//            ans ++;
//            i--;
//            j++;
//        }
//    }
//    public boolean isPalindrome(String a) {
//        if(a == null || a.length()==0) return false;
//        char [] charA = a.toCharArray();
//        int l = 0, r = a.length()-1;
//        while(l < r) {
//            if(charA[l]!=charA[r]) return false;
//            l++;r--;
//        }
//        return true;
//    }

    int ans=0;
    public int countSubstrings(String s) {
        if(s == null || s.length() < 1) return ans;
        if(s.length() == 1) return 1;
        for(int i=0; i<s.length(); i++) {
            helper(i, i, s);
            helper(i, i+1, s);
        }
        return ans;
    }
    private void helper(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ans ++;
            left--;
            right++;
        }
    }
    private boolean isPalindrome(String s) {
        if(s.length() == 1) return true;
        int left = 0, right = s.length() -1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String [] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
    }
}
