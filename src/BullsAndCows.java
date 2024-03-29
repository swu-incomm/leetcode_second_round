import java.util.*;
/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to
 * indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 * Constraints:
 *
 * 1 <= secret.length, guess.length <= 1000
 * secret.length == guess.length
 * secret and guess consist of digits only.
 */
public class BullsAndCows {
    /**
    public String getHint(String secret, String guess) {
        if(secret == null || secret.length() ==0 || guess == null || guess.length()==0) return "0A0B";
        int [] secretCows = new int [10];
        int [] guessCows = new int [10];
        int numOfBulls = 0;
        int numOfCows = 0;
        for(int i =0; i<secret.length(); i++) {
            char temp1 = secret.charAt(i);
            char temp2 = guess.charAt(i);
            if(temp1 == temp2) {
                numOfBulls++;
            } else {
                secretCows[temp1-'0'] ++;
                guessCows[temp2-'0']++;
            }
        }
        for(int i=0; i<10;i++) {
            numOfCows += Math.min(secretCows[i], guessCows[i]);
        }
        return numOfBulls + "A" + numOfCows + "B";
    }**/
    public static void main(String [] args) {
        String a = "1123";
        String b = "0111";
        BullsAndCows bullsAndCows = new BullsAndCows();
        bullsAndCows.getHint(a, b);
    }
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        char [] a1 = secret.toCharArray();
        char [] a2 = guess.toCharArray();
        int [] count = new int [10];
        for(int i=0; i<a1.length; i++) {
            if(a1[i] == a2[i]) {
                bull++;
                a1[i] = '*';
                a2[i] = '*';
            }
            if(a1[i] != '*') {
                count[a1[i] - '0'] ++;
            }
        }
        for(int i=0; i<a2.length; i++) {
            char ch = a2[i];
            if(ch != '*' && count[ch - '0'] > 0) {
                cow++;
                count[ch - '0']--;
            }
        }
        return bull + "A" + cow + "B";
    }
}
