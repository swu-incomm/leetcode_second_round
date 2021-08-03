/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: s = "aaab"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
import java.util.*;
public class ReorganizeString {
    class Pair {
        private char ch;
        private int freq;
        public char getCh() {
            return this.ch;
        }
        public void setCh(char ch) {
            this.ch = ch;
        }
        public int getFreq() {
            return this.freq;
        }
        public void setFreq(int freq) {
            this.freq = freq;
        }
        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        char [] chars = s.toCharArray();
        Map<Character, Pair> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.getFreq() - a.getFreq());
        for(char ch : chars) {
            if(!map.containsKey(ch)) {
                map.put(ch, new Pair(ch, 1));
            } else {
                Pair temp = map.get(ch);
                temp.setFreq(temp.getFreq() + 1);
                map.put(ch, temp);
            }
        }
        for(Map.Entry entry : map.entrySet()) {
            Pair temp = (Pair) entry.getValue();
            pq.offer(temp);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair temp = pq.poll();
            if(sb.length() == 0 || temp.getCh() != sb.charAt(sb.length()-1)) {
                sb.append(temp.getCh());
                if(temp.getFreq() > 1) {
                    temp.setFreq(temp.getFreq() -1);
                    pq.offer(temp);
                }
;           } else {
                Pair temp2 = pq.poll();
                if(temp2 == null) return "";
                sb.append(temp2.getCh());
                if(temp2.getFreq() > 1) {
                    temp2.setFreq(temp2.getFreq() -1);
                    pq.offer(temp2);
                }
                pq.offer(temp);
            }
        }
        String res=  sb.toString();
        for(int i=1; i<sb.length(); i++) {
            if(res.charAt(i) == res.charAt(i-1)) return "";
        }
        return sb.toString();
    }
}
