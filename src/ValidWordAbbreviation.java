/**
 * A string can be abbreviated by replacing any number of non-adjacent substrings with their lengths. For example,
 * a string such as "substitution" could be abbreviated as (but not limited to):
 *
 * "s10n" ("s ubstitutio n")
 * "sub4u4" ("sub stit u tion")
 * "12" ("substitution")
 * "su3i1u2on" ("su bst i t u ti on")
 * "substitution" (no substrings replaced)
 * Note that "s55n" ("s ubsti tutio n") is not a valid abbreviation of "substitution" because the replaced substrings are adjacent.
 *
 * Given a string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "internationalization", abbr = "i12iz4n"
 * Output: true
 * Example 2:
 *
 * Input: word = "apple", abbr = "a2e"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 20
 * word consists of only lowercase English letters.
 * 1 <= abrr.length <= 10
 * abbr consists of lowercase English letters and digits.
 * All the integers in abrr will fit in a 32-bit integer.
 */
public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int count = 0, i = 0, k = 0;
        char [] chars = abbr.toCharArray();
        while(i < abbr.length()) {
            if(Character.isDigit(chars[i]) && chars[i] == '0') return false;
            while(i < abbr.length() && Character.isDigit(chars[i])) {
                count = count * 10 + chars[i] - '0';
                i++;
            }
            k += count;
            count = 0;
            if(k == word.length() && i == abbr.length()) return true;
            if(k >= word.length() || i >= abbr.length() || chars[i++] != word.charAt(k++)) return false;
        }
        if(k != word.length()) return false;
        return true;
    }

    public static void main(String ... args) {
        validWordAbbreviation("internationalization","i5a11o1");
    }
}
