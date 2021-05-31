/**
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello"
 * Output: "hello"
 * Example 2:
 *
 * Input: s = "here"
 * Output: "here"
 * Example 3:
 *
 * Input: s = "LOVELY"
 * Output: "lovely"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s consists of printable ASCII characters.
 */
public class ToLowerCase {
    String alphabetL = "abcdefghijklmnopqrstuvwxyz";
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if(temp - 'A' >= 0 && temp -'Z' <=0) {
                temp = alphabetL.charAt(temp - 'A');
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    public static void main(String args []) {
        System.out.println((int)'a');
        System.out.println((int)'A');
    }
}
