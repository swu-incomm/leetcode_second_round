/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0) {
            int temp = x % 10;
            x/=10;
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && temp > 7)) return 0;
            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && temp < -8)) return 0;
            ans *= 10;
            ans += temp;
        }
        System.out.println(ans);
        return ans;
    }

    public int reverse_long(int x) {
        long ans = 0;
        while(x != 0) {
            ans *= 10;
            ans += x % 10;
            x /=10;
            if(ans > Integer.MAX_VALUE || ans<Integer.MIN_VALUE) return 0;
        }
        return (int)ans;
    }

    public static void main(String [] args) {
        int test = 120;
        ReverseInteger reverseInteger = new ReverseInteger();

        reverseInteger.reverse(test);
    }
}
