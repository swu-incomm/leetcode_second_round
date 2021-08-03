/**
 * Given a character array s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
 *
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Example 2:
 *
 * Input: s = ["a"]
 * Output: ["a"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
 * There is at least one word in s.
 * s does not contain leading or trailing spaces.
 * All the words in s are guaranteed to be separated by a single space.
 */
//Reverse entire string then each word
public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        reverseCharArray(s, 0, s.length-1);
        int start = 0, end = 0;
        while(end < s.length) {
          while(end < s.length && s[end] != ' ') {
              end++;
          }
          reverseCharArray(s, start, end-1);
          start = end + 1;
          end++;
        }
    }

    public void reverseCharArray(char [] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
