/**
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
 * so that the concatenation of the two words words[i] + words[j] is a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * Example 3:
 *
 * Input: words = ["a",""]
 * Output: [[0,1],[1,0]]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] consists of lower-case English letters.
 */
import java.util.*;
public class PalindromePairs {
    List<List<Integer>> ans;
    public List<List<Integer>> palindromePairs(String[] words) {
        ans = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words.length;j++) {
                if(i == j) continue;
                String temp = words[i] + words[j];
                if(isPalindrome(temp)) {
                    ArrayList<Integer> subAns = new ArrayList<>();
                    subAns.add(i);
                    subAns.add(j);
                    ans.add(subAns);
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String a) {
        int left = 0;
        int right = a.length()-1;
        while(left < right) {
            if(a.charAt(left) != a.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
