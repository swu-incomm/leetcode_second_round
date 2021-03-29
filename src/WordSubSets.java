import java.util.*;

/**
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 *
 * Now, say that word b is a subset of word a if every 'letter' in b occurs in a, including multiplicity.
 * For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 *
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 *
 * Return a list of all universal words in A.  You can return the words in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * Example 2:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"]
 * Example 3:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"]
 * Example 4:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * Output: ["google","leetcode"]
 * Example 5:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * Output: ["facebook","leetcode"]
 *
 *
 * Note:
 *
 * 1 <= A.length, B.length <= 10000
 * 1 <= A[i].length, B[i].length <= 10
 * A[i] and B[i] consist only of lowercase letters.
 * All words in A[i] are unique: there isn't i != j with A[i] == A[j].
 */
public class WordSubSets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int [] maxLetterCountB = new int [26];

        for(int i=0; i<B.length; i++) {
            int [] temp = countLetters(B[i]);
            for(int j=0; j<26; j++) {
                maxLetterCountB[j] = Math.max(maxLetterCountB[j], temp[j]);
            }
        }

        for(int i=0; i<A.length; i++) {
            int [] tempA = countLetters(A[i]);
            boolean flag = true;
            for(int j=0;j<26; j++) {
                if(tempA[j] < maxLetterCountB[j]) {
                    flag= false;
                    break;
                }
            }
            if(flag) {
                result.add(A[i]);
            }
        }
        return result;
    }

    private int [] countLetters(String word) {
        int [] result = new int [26];
        if(word == null || word.length() == 0) return result;
        for(int i=0; i<word.length(); i++) {
            result[word.charAt(i) - 'a'] ++;
        }
        return result;
    }
}
