/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroesIterative(int n) {
        int ans = 0;
        while(n != 0) {
            ans += n/5;
            n/=5;
        }
        return ans;
    }

    public int trailingZeroesRecursive(int n) {
        if(n < 5) return 0;
        if(n < 10) return 1;
        return trailingZeroesRecursive(n/5 + trailingZeroesRecursive(n/5));
    }
}
