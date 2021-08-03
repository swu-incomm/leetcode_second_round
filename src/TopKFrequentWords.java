/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
import java.util.*;
public class TopKFrequentWords {
    class Pair {
        private String str;
        private int freq;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public Pair(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Pair> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq == b.freq ? b.getStr().compareTo(a.getStr()) : a.freq - b.getFreq());
        for(String str: words) {
            if(!map.containsKey(str)) {
                map.put(str, new Pair(str, 1));
            } else {
                Pair temp = map.get(str);
                temp.setFreq(temp.getFreq() + 1);
                map.put(str, temp);
            }
        }

        for(Map.Entry entry: map.entrySet()) {
            pq.offer((Pair)entry.getValue());
            if(pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(pq.size() > 0) {
            res.add(0, pq.poll().getStr());
        }
        return res;
    }
}
