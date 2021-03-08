import java.util.*;
/**
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 *
 *
 * Example 1:
 *
 * Input: num = "69"
 * Output: true
 * Example 2:
 *
 * Input: num = "88"
 * Output: true
 * Example 3:
 *
 * Input: num = "962"
 * Output: false
 * Example 4:
 *
 * Input: num = "1"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= num.length <= 50
 * num consists of only digits.
 * num does not contain any leading zeros except for zero itself.
 * 边界考虑： 长度为0， 1； 倒过来相同的数字， 倒过来不相同的数字； left指针和right指针相遇的判断
 */
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return false;
        if(num.length() == 1) {
            int value = Integer.valueOf(num.charAt(0)-'0');
            return value == 0 || value == 1 || value == 8;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 9);
        map.put(9, 6);
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        int left =0, right = num.length()-1;
        while(left <= right) {
            int a = Integer.valueOf(num.charAt(left)-'0');
            int b = Integer.valueOf(num.charAt(right)-'0');
            System.out.println(a);
            System.out.println(b);
            if(!map.containsKey(a) || map.get(a) != b) {
                return false;
            }
            left ++;
            right--;
        }
        return true;
    }
}
