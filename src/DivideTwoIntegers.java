/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8
 * and truncate(-2.7335)
 * = -2.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 * 解法为将除数不断乘以二
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) sign = -1;
        long dividendL = Math.abs((long)dividend);
        long divisorL = Math.abs((long)divisor);
        if(dividendL < divisorL || dividend == 0) return 0;
        long ansL = divideRecursive(dividendL, divisorL);
        if(ansL > Integer.MAX_VALUE) {
            if(sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        return (int) ansL * sign;
    }

    private long divideRecursive(long dividend, long divisor) {
        if(dividend < divisor) return 0;
        long sum = divisor;
        long num = 1;
        while(sum + sum < dividend) {
            sum +=sum;
            num+=num;
        }
        return num + divideRecursive(dividend - sum, divisor);
    }
}
