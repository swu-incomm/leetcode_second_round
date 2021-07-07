/**
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 *
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 5
 * Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
 * Example 2:
 *
 * Input: n = 2
 * Output: 10
 * Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 * Example 3:
 *
 * Input: n = 5
 * Output: 68
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 10^4
 */
import java.util.*;
public class countVowelsPermutation {
    int count;
    Map<Character, char []> hashMap = new HashMap<>();
    public int countVowelPermutationBruteForce(int n) {
        char [] vowels = {'a', 'e', 'i', 'o', 'u'};
        hashMap.put('\0', vowels);
        hashMap.put('a', new char[] {'e'});
        hashMap.put('e', new char[] {'a', 'i'});
        hashMap.put('i', new char[] {'a', 'e', 'o', 'u'});
        hashMap.put('o', new char[] {'i', 'u'});
        hashMap.put('u', new char[] {'a'});
        backtrack(n, "", '\0');
        return count;
    }

    public void backtrack(int n, String cur, char curChar) {
        if(cur.length() == n) {
            count++;
            return;
        }
        char [] process = hashMap.get(curChar);
        for(int i=0; i<process.length;i++) {
            cur+=process[i];
            backtrack(n, cur, process[i]);
            cur = cur.substring(0, cur.length()-1);
        }
    }

    public static void main(String [] args) {
        //String test = "";
        //System.out.println(test.charAt(0));
    }

    int mod = (int)(1e9) + 7;
    HashMap<String, Long> map = new HashMap<>();

    public int countVowelPermutation(int n) {
        long a = solve(n, 'a');
        long i = solve(n, 'i');
        long u = solve(n, 'u');
        long e = solve(n, 'e');
        long o = solve(n, 'o');
        return (int)((a+i+u+e+o) % mod);
    }

    public long solve(int n, char cur) {
        String key = n+","+cur;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        if (n == 1) {
            return 1;
        }

        long result;
        if(cur == 'a') {
            result = (solve(n-1, 'e')) % mod;
        } else if(cur == 'e') {
            result = (solve(n-1, 'a') + solve(n-1, 'i')) % mod;
        } else if(cur == 'i') {
            result = (solve(n-1, 'e') + solve(n-1, 'o') + solve(n-1, 'u') + solve(n-1, 'a')) % mod;
        } else if(cur == 'o') {
            result = (solve(n-1, 'i') + solve(n-1, 'u')) % mod;
        } else {
            result = (solve(n-1, 'a')) % mod;
        }
        map.put(n+","+cur, result);
        return result;
    }
}
