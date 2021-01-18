/**
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are
 * lexicographically sorted.
 *
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 5
 * Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
 * Example 2:
 *
 * Input: n = 2
 * Output: 15
 * Explanation: The 15 sorted strings that consist of vowels only are
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 * Example 3:
 *
 * Input: n = 33
 * Output: 66045
 *
 *
 * Constraints:
 *
 * 1 <= n <= 50
 * back tracking method
 */
public class CountSortedVowelStrings {
    char [] alphabet = new char [] {
      'a', 'e', 'i', 'o', 'u'
    };
    int ans;
    public int countVowelStrings(int n) {
        if(n == 0) return 0;
        backtrack(0, "", n);
        return ans;
    }
    public void backtrack(int index, String cur, int n) {
        if(cur.length() == n) {
            ans ++;
            //System.out.println(cur);
            return;
        }
        for(int i = index; i<alphabet.length; i++) {
            cur = cur + alphabet[i];
            backtrack(i, cur, n);
            cur = cur.substring(0, cur.length()-1);
        }
    }
    public static void main(String [] args) {
        CountSortedVowelStrings countSortedVowelStrings = new CountSortedVowelStrings();
        System.out.println(countSortedVowelStrings.countVowelStrings(2));
    }
}
