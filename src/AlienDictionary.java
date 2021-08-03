/**
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 *
 * You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted
 * lexicographically by the rules of this new language.
 *
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by t
 * he new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
 *
 * A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s
 * comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is
 * smaller if and only if s.length < t.length.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of only lowercase English letters.
 */
import java.util.*;
public class AlienDictionary {
    public static String alienOrder(String[] words) {
        //two data structures, one for adjList another for in-degrees count
        //build the graph
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for(String word : words) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                count.put(chars[i], 0);
                adjList.put(chars[i], new ArrayList<>());
            }
        }

            for(int i=0; i<words.length-1; i++) {
                String word1 = words[i];
                String word2 = words[i + 1];
                int len = word1.length() > word2.length() ? word2.length() : word1.length();
                if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
                for(int j=0; j<len; j++) {
                    char ch1 = word1.charAt(j);
                    char ch2 = word2.charAt(j);
                    if(ch1 != ch2) {
                        if(!adjList.get(ch1).contains(ch2)) {
                            adjList.get(ch1).add(ch2);
                            count.put(ch2, count.get(ch2) + 1);
                        }
                        break;
                    }
                }
            }
            //topologic sort
            Queue<Character> queue = new LinkedList<>();
            for(Map.Entry entry : count.entrySet()) {
                int inDegree = (int)entry.getValue();
                if(inDegree == 0) {
                    queue.offer((char)entry.getKey());
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i=0; i<size; i++) {
                    char temp = queue.poll();
                    sb.append(temp);
                    List<Character> list = adjList.get(temp);
                    for(int j = 0; j<list.size(); j++) {
                        char ch = list.get(j);
                        count.put(ch, count.get(ch) - 1);
                        if(count.get(ch) == 0) {
                            queue.offer(ch);
                        }
                    }
                }
            }

            //there is a cycle, no result
            for(Map.Entry entry : count.entrySet()) {
                int inDegree = (int)entry.getValue();
                if(inDegree != 0) {
                    return "";
                }
            }
            return sb.toString();
    }

    public static void main(String [] args) {
        String [] test = {"wrt","wrf","er","ett","rftt","te"};
        alienOrder(test);
    }
}
