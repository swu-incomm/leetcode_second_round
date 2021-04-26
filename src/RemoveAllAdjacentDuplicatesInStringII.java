import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 *
 * It is guaranteed that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 *
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 *
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 */

public class RemoveAllAdjacentDuplicatesInStringII {
    class Pair {
        char key;
        int freq;

        public char getKey() {
            return key;
        }

        public void setKey(char key) {
            this.key = key;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public Pair(char key, int value) {
            this.key = key;
            this.freq = value;
        }
    }

    public String removeDuplicates(String s, int k) {
        StringBuilder ans = new StringBuilder();
        Stack<Pair> stack = new Stack<>();
        for(char i : s.toCharArray()) {
            if(stack.isEmpty() || stack.peek().getKey() != i) {
                stack.push(new Pair(i, 1));
                continue;
            }
            Pair temp = stack.pop();
            temp.setFreq(temp.getFreq() + 1);
            if(temp.getFreq() != k) {
                stack.push(temp);
            }
        }
        while(!stack.isEmpty()) {
            Pair temp = stack.pop();
            int tempFreq = temp.getFreq();
            char tempKey = temp.getKey();
            while(tempFreq>0) {
                ans.insert(0, tempKey);
                tempFreq--;
            }
        }
        return ans.toString();
    }

    public static void main(String [] args) {
        RemoveAllAdjacentDuplicatesInStringII solution = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(solution.removeDuplicates("abcd", 2));
    }
}
