/**
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 */
import java.util.*;
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        if(high < low) return ans;
        for(int i =1; i<9; i++) {
            backtrack(low, high, i, ans);
        }
        Collections.sort(ans);
        return ans;
    }

    public void backtrack(int low, int high, int start, List<Integer> ans) {
        if(start <= high && start >= low) {
            ans.add(start);
        } if(start > high) {
            return;
        } if(start % 10 == 9) {
            return;
        }
        int lastDig = start % 10;
        int nextStart = start * 10 + lastDig + 1;
        backtrack(low, high, nextStart, ans);
    }

    public List<Integer> sequentialDigitsQueue(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        if(high < low) return ans;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<9; i++) { queue.offer(i); }
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            int lastDigit = temp % 10;
            if(lastDigit != 9) {
                int newGeneratedNum = temp * 10 + lastDigit + 1;
                if(newGeneratedNum <= high) {
                    queue.offer(newGeneratedNum);
                    if(newGeneratedNum > low) {
                        ans.add(newGeneratedNum);
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
