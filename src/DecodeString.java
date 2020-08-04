import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,
 * k. For example, there won't be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */
public class DecodeString {
    public String decodeString(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int index = 0;
        while(index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                int k = 0;
                while(Character.isDigit(s.charAt(index))) {
                    k = k * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(k);
            } else if (s.charAt(index) == '[') {
                stringStack.push(res);
                res = "";
                index ++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for(int i = 0; i<count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            } else {
                res = res + s.charAt(index++);
            }
        }
        return res;
    }
}
