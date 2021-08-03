import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    /**
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        queue.offer(beginWord);
        int layer = 0;
        while(!queue.isEmpty()) {
            //queue's size is dynamically increased
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                String cur = queue.poll();
                if(cur.equals(endWord)) return layer + 1;
                addToQueue(set, queue, cur);
            }
            layer++;
        }
        return 0;
    }

    public void addToQueue(Set<String> set, Queue<String> queue, String cur) {
        for(int i = 0; i<cur.length();i++) {
            //important otherwise the chars is changed every loop
            char [] chars = cur.toCharArray();
            for(int j = 0; j<26;j++) {
                char tempChar = (char)('a' + j);
                if(tempChar == chars[i]) continue;
                chars[i] = tempChar;
                String temp = String.valueOf (chars);
                if(set.contains(temp)) {
                    set.remove(temp);
                    queue.offer(temp);
                }
            }
        }
    }
 **/
    public static void main(String [] args) {
        WordLadder wordLadder = new WordLadder();
        String beginWord = "hot";
        String endWord = "dot";
        String [] strings = {"hot","dot","dog"};
        List wordList = new ArrayList();
        Collections.addAll(wordList, strings);
        wordList.stream().forEach(System.out::println);
        System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
    }

    /**
     * Constraints:
     *
     * 1 <= beginWord.length <= 10
     * endWord.length == beginWord.length
     * 1 <= wordList.length <= 5000
     * wordList[i].length == beginWord.length
     * beginWord, endWord, and wordList[i] consist of lowercase English letters.
     * beginWord != endWord
     * All the words in wordList are unique.
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // We use BFS approach to proceed
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i=0; i<size; i++) {
                String cur = queue.poll();
                for(int j=0; j<cur.length(); j++) {
                    char [] chars = cur.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        String nextString = new String (chars);
                        if(nextString.equals(endWord)) return step;
                        else if(!nextString.equals(cur) && set.contains(nextString)) {
                            queue.offer(nextString);
                        }
                    }
                }
                set.remove(cur);
            }
        }
        return 0;
    }
}
