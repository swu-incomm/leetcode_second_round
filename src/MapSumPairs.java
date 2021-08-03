/**
 * Design a map that allows you to do the following:
 *
 * Maps a string key to a given value.
 * Returns the sum of the values that have a key with a prefix equal to a given string.
 * Implement the MapSum class:
 *
 * MapSum() Initializes the MapSum object.
 * void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed,
 * the original key-value pair will be overridden to the new one.
 * int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
 *
 *
 * Example 1:
 *
 * Input
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * Output
 * [null, null, 3, null, 5]
 *
 * Explanation
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 *
 * Constraints:
 *
 * 1 <= key.length, prefix.length <= 50
 * key and prefix consist of only lowercase English letters.
 * 1 <= val <= 1000
 * At most 50 calls will be made to insert and sum.
 */
import java.util.*;
public class MapSumPairs {
    class MapSum {
        TrieNode root;
        Map<String, Integer> map;
        /** Initialize your data structure here. */
        public MapSum() {
            this.root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            TrieNode node = this.root;
            char [] chars = key.toCharArray();
            int delta = val - map.getOrDefault(key, 0);
            node.value += delta;
            map.put(key, val);
            for(int i=0; i<chars.length; i++) {
                if(node.nodes[chars[i]-'a'] == null) {
                    node.nodes[chars[i]-'a'] = new TrieNode();
                }
                node = node.nodes[chars[i] - 'a'];
                node.value += delta;
            }
        }

        public int sum(String prefix) {
            TrieNode node = this.root;
            for(char c : prefix.toCharArray()) {
                if(node.nodes[c - 'a'] == null) return 0;
                node = node.nodes[c - 'a'];
            }
            return node.value;
        }
    }

    class TrieNode {
        int value;
        TrieNode [] nodes = new TrieNode[26];
    }
}

