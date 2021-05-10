import java.util.Arrays;

/*
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
0 <= n <= 5 * 106
 */
//All non-prime numbers can be devided by prime numbers
public class CountPrimes {
//    public int countPrimes(int n) {
//        int count = 0;
//        boolean [] filter = new boolean[n];
//        Arrays.fill(filter, true);
//        for(int i = 2; i<n; i++) {
//            if(filter[i] == true) {
//                System.out.println(i);
//                count ++;
//                for(int j = 2; j * i<n;j++) {
//                    filter[j * i] = false;
//                }
//            }
//        }
//        return count;
//    }
    public static void main(String [] args) {
        CountPrimes countPrimes = new CountPrimes();
        countPrimes.countPrimes(10);
    }
    //traditional ways
    //exceed time limit
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int ans = 0;
        for(int i=2; i<=n; i++) {
            if(isPrimes(i)) ans++;
        }
        return ans;
    }
    public boolean isPrimes (int n) {
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    //algorithm
    public int countPrimesAlg(int n) {
        if(n <= 2) return 0;
        boolean [] table = new boolean[n];
        int count = 0;
        for(int i=2; i * i < n; i++) {
            for(int j=i*i; j<n; j+=i) {
                table[j] = true;
            }
        }
        for(int i=2; i<n; i++) {
            if(!table[i]) count++;
        }
        return count;
    }
}
