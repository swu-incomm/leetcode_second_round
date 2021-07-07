/**
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters
 * (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 *
 * Example 1:
 *
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 * Example 2:
 *
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * s and words[i] consist of only lowercase English letters.
 */
import java.util.*;
public class NumberOfMatchingSubsequences {
    //TLE solution
//    public int numMatchingSubseq(String s, String[] words) {
//        int res = 0;
//        for(String word : words) {
//            if(isSubseq(s, word)) {
//                res++;
//            }
//        }
//        return res;
//    }
//    public boolean isSubseq(String s, String word) {
//        int i = 0, j = 0;
//        while(i < word.length() && j < s.length()) {
//            if(word.charAt(i) == s.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                j++;
//            }
//        }
//        return i == word.length();
//    }
    public int numMatchingSubseq(String s, String[] words) {
        List<String>[] buckets = new List[26];
        for(int i=0; i<26; i++) buckets[i] = new ArrayList<>();
        for(String word: words) {
            char start = word.charAt(0);
            buckets[start - 'a'].add(word);
        }
        int i = 0, count= 0;
        while(i < s.length()) {
            //printTable(buckets);
            char startChar = s.charAt(i);
            List<String> bucket = buckets[startChar - 'a'];
            int size = bucket.size();
            for(int j=0; j<size;j++) {
                String temp = bucket.get(j);
                temp = temp.substring(1);
                if(temp.length()==0) {
                    count++;
                }
                else {
                    char newStart = temp.charAt(0);
                    buckets[newStart - 'a'].add(temp);
                }
            }
            for(int k=0; k<size;k++)bucket.remove(0);
            //System.out.println("at " + i +" th iteration, count = " + count + " startChar: " + startChar);
            //System.out.println();
            i++;
        }
        return count;
    }
    public void printTable (List<String> [] buckets) {
        for(List<String> bucket: buckets) {
            if(bucket.size() >0) {
                for(String s : bucket) {
                    System.out.printf("%s ", s);
                }
                System.out.println();
            }
        }
    }
    public static void main(String [] args) {
        NumberOfMatchingSubsequences n = new NumberOfMatchingSubsequences();
        n.numMatchingSubseq("abcde", new String []{"a","bb","acd","ace"});
        System.out.println("bb".substring(1));
    }
}
