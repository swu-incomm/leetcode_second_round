/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 0
 * Example 3:
 *
 * Input: s = "ab"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lower-case English letters only.
 */
public class PalindromePartitioningII {
    /**
     * // Naive back track
    public int minCut(String s) {
       return  backtrack(s, 0, s.length()-1, s.length()-1);
    }

    public int backtrack(String s, int start, int end, int cut) {
        if(start == end || isPalindrome(s, start, end)) {
            return 0;
        }
        for(int i=start; i<=end; i++) {
            if(isPalindrome(s, start, i)) {
                cut = Math.min(cut, 1 + backtrack(s, i + 1, end, cut));
            }
        }
        return cut;
    }
    public boolean isPalindrome(String s, int start, int end) {
        if(s == null || s.length() == 0) return true;
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
     **/

    private Integer memoCuts[][];
    public int minCut(String s) {
        memoCuts = new Integer[s.length()][s.length()];
        return  backtrack(s, 0, s.length()-1, s.length()-1);
    }

    public int backtrack(String s, int start, int end, int cut) {
        if(start == end || isPalindrome(s, start, end)) {
            return 0;
        }
        if (memoCuts[start][end] != null) {
            return memoCuts[start][end];
        }
        for(int i=start; i<=end; i++) {
            if(isPalindrome(s, start, i)) {
                cut = Math.min(cut, 1 + backtrack(s, i + 1, end, cut));
            }
        }
        memoCuts[start][end] = cut;
        return cut;
    }
    public boolean isPalindrome(String s, int start, int end) {
        if(s == null || s.length() == 0) return true;
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
