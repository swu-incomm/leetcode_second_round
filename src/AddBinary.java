/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        a= reverseString(a);
        b = reverseString(b);
        int i = 0, inc = 0;
        while(i < a.length() || i < b.length()) {
            int add1 = i < a.length() ? a.charAt(i) - '0' : 0;
            int add2 = i < b.length() ? b.charAt(i) - '0' : 0;
            int temp = add1 + add2 + inc;
            inc = temp > 1 ? 1 : 0;
            temp = temp % 2;
            sb.insert(0, temp);
            i++;
        }
        if(inc > 0) sb.insert(0, 1);
        return sb.toString();
    }

    String reverseString(String a) {
        char [] chars = a.toCharArray();
        int left = 0, right = chars.length -1;
        while(left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String [] args) {
        AddBinary addBinary = new AddBinary();
        addBinary.addBinary("11", "1");
    }
}
