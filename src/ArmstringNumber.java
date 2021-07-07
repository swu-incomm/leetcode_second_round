/**
 * Given an integer n, return true if and only if it is an Armstrong number.
 *
 * The k-digit number n is an Armstrong number if and only if the kth power of each digit sums to n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 153
 * Output: true
 * Explanation: 153 is a 3-digit number, and 153 = 13 + 53 + 33.
 * Example 2:
 *
 * Input: n = 123
 * Output: false
 * Explanation: 123 is a 3-digit number, and 123 != 13 + 23 + 33 = 36.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 108
 */
import java.util.*;
public class ArmstringNumber {
    public boolean isArmstrong(int n) {
        int tempN = n;
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            int temp = n % 10;
            list.add(temp);
            n/=10;
        }
        int count = list.size();
        int sum = 0;
        for(int i : list) {
            int temp = calculateExp(i, count);
            sum+=temp;
        }
        return sum == tempN;
    }

    public int calculateExp(int n, int e) {
        if(e == 1) return n;
        if(n == 1) return 1;
        if(n == 0) return 0;
        return n * calculateExp(n, e-1);
    }
}
