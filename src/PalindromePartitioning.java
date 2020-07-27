import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> subList = new ArrayList<>();
        backtrack(s, 0, ans, subList);
        return ans;
    }

    public void backtrack(String s, int pos, List<List<String>> ans, List<String> subList) {
        if(pos == s.length()) {
            ans.add(new ArrayList<>(subList));
            return;
        }
        for(int i=pos+1; i<=s.length();i++) {
            String temp = s.substring(pos, i);
            if(isPalindrome(temp)) {
                subList.add(temp);
                backtrack(s, i, ans, subList);
                subList.remove(subList.size()-1);
            }
        }
    }

    public boolean isPalindrome(String a) {
        if(a==null || a.length() ==0) return false;
        int l = 0;
        int r =a.length()-1;
        char[] aChar= a.toCharArray();
        while(l<r) {
            if(aChar[l] != aChar[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String [] args) {
        //subString test
        String test = "test";
        System.out.println(test.substring(0, 0));
        System.out.println(test.substring(0, 1));
    }
}
