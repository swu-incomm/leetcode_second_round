import java.util.Arrays;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * Example 3:
 *
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 *
 *
 * Constraints:
 *
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1, s2, and s3 consist of lowercase English letters.
 *
 *
 * Follow up: Could you solve it using only O(s2.length) additional memory space?
 */
public class InterLeavingString {
    /*
    //This is brute force dfs approach
    //This will cause time out, we need to use memorized dfs
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        return backtrack(s1, 0, s2, 0, "", s3);
    }

    public boolean backtrack(String s1, int i, String s2, int j, String cur, String s3) {
        if(i == s1.length() && j ==s2.length() && cur.equals(s3)) {
            return true;
        }
        boolean ans1 = false;
        boolean ans2 = false;
        if(i < s1.length()) {
            ans1 = backtrack(s1, i+1, s2, j, cur + s1.charAt(i), s3);
        }
        if(j < s2.length()) {
            ans2 = backtrack(s1, i, s2, j+1, cur + s2.charAt(j), s3);
        }
        return ans1 || ans2;
    }
    */

    //memo backtrack
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int [][] mem = new int [s1.length()][s2.length()];
        for(int [] sub : mem) {
            Arrays.fill(sub, -1);
        }
        return backtrack(s1, 0, s2, 0, "", s3, 0,  mem);
    }

    public boolean backtrack(String s1, int i, String s2, int j, String cur, String s3, int k, int [][] mem) {
        if(i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if(j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (mem[i][j] >= 0) {
            return mem[i][j] == 1 ? true : false;
        }
        boolean ans1 = false;
        boolean ans2 = false;
        if(s3.charAt(k) == s1.charAt(i)) {
            ans1 = backtrack(s1, i+1, s2, j, cur + s1.charAt(i), s3, k+1,mem);
        }
        if(s3.charAt(k) == s2.charAt(j)) {
            ans2 = backtrack(s1, i, s2, j+1, cur + s2.charAt(j), s3, k+1, mem);
        }
        mem[i][j] = (ans1 || ans2) ? 1 : 0;
        return ans1 || ans2;
    }

    //DP solution
    public boolean isInterleaveDp(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean [][] dp = new boolean [s1.length() + 1][s2.length() + 1];
        //s1, s2, s3 are empty string and s1 + s2  = s3
        dp[0][0] = true;
        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0) {
                    dp[i][j] = s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1];
                } else if(j == 0) {
                    dp[i][j] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0];
                } else {
                    dp[i][j] = (s3.charAt(i + j - 1) == s1.charAt(i-1) && dp[i-1][j]) || (s3.charAt(i+j-1) == s2.charAt(j-1) && dp[i][j-1]);
                }
            }
        }
        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                System.out.printf("%b ", dp[i][j]);
            }
            System.out.println();
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String [] args) {
        InterLeavingString interLeavingString = new InterLeavingString();
        interLeavingString.isInterleaveDp("db", "b", "cbb");
    }
}
