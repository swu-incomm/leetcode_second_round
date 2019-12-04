import java.util.Arrays;

/*
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
//All non-prime numbers can be devided by prime numbers
public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean [] filter = new boolean[n];
        Arrays.fill(filter, true);
        for(int i = 2; i<n; i++) {
            if(filter[i] == true) {
                System.out.println(i);
                count ++;
                for(int j = 2; j * i<n;j++) {
                    filter[j * i] = false;
                }
            }
        }
        return count;
    }
    public static void main(String [] args) {
        CountPrimes countPrimes = new CountPrimes();
        countPrimes.countPrimes(10);
    }

}
