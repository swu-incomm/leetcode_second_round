import java.util.HashSet;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
  (where it will stay), or it loops endlessly in a cycle which does not include 1.
   Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class HappyNumber {
    HashSet<Integer> visited = new HashSet<>();
    public boolean isHappy(int n) {
        if(n == 0) return false;
        if(visited.contains(n)) return false;
        visited.add(n);
        int res = 0;
        while(n != 0) {
            res += Math.pow(n%10, 2);
            n/=10;
        }
        System.out.println(res);
      return res == 1 ? true : isHappy(res);
    }
    public static void main(String [] args) {
        int test = 2;
        HappyNumber happyNumber = new HappyNumber();
        happyNumber.isHappy(test);
    }
}
