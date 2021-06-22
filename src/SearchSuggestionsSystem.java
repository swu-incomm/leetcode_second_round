/**
 * Given an array of strings products and a string searchWord. We want to design a system that suggests
 * at most three product names from products after each character of searchWord is typed. Suggested products
 * should have common prefix with the searchWord. If there are more than three products with a common prefix return the
 * three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 * Example 2:
 *
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Example 3:
 *
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * Example 4:
 *
 * Input: products = ["havana"], searchWord = "tatiana"
 * Output: [[],[],[],[],[],[],[]]
 *
 *
 * Constraints:
 *
 * 1 <= products.length <= 1000
 * There are no repeated elements in products.
 * 1 <= Σ products[i].length <= 2 * 10^4
 * All characters of products[i] are lower-case English letters.
 * 1 <= searchWord.length <= 1000
 * All characters of searchWord are lower-case English letters.
 */

import java.util.*;
public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Trie trie = new Trie();
        for(String i : products) {
            trie.insert(i);
        }
        String temp = new String();
        for(char c : searchWord.toCharArray()) {
            temp += c;
            res.add(trie.findWordByPrefix(temp));
        }
        return res;
    }
    class Trie {
        class TrieNode{
            boolean isWord;
            TrieNode [] children = new TrieNode[26];
        }
        private TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        private List<String> subAns;

        public void insert(String word) {
            TrieNode node = root;
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                if(node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }

        public List<String> findWordByPrefix(String prefix) {
            this.subAns = new ArrayList<>();
            TrieNode node = this.root;
            char [] chArr = prefix.toCharArray();
            for(char c : chArr) {
                if(node.children[c - 'a'] != null) {
                    node = node.children[c - 'a'];
                } else {
                    return this.subAns;
                }
            }
            dfs(prefix, node);
            return this.subAns;
        }

        public void dfs(String prefix, TrieNode node) {
            if(subAns.size() == 3) {
                return;
            }
            if(node.isWord) {
                subAns.add(prefix);
            }
            for(char i='a'; i<'z'; i++) {
                if(node.children[i - 'a'] != null) {
                    dfs(prefix + i, node.children[i - 'a']);
                }
            }
        }
    }
}
