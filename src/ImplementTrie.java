/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class ImplementTrie {
    public static void main(String [] args) {}
}

class Trie {
    class TrieNode {
        TrieNode [] children = new TrieNode[26];
        String item = "";
    }

    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char [] chars = word.toCharArray();
        TrieNode node = root;
        for(char i : chars) {
            if(node.children[i-'a'] == null) {
                node.children[i-'a'] = new TrieNode();
            }
            node = node.children[i-'a'];
        }
        node.item = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int p = 0;
        char [] chars = word.toCharArray();
        TrieNode node = root;
        while(p < chars.length) {
            if(node.children[chars[p]-'a'] == null) {
                return false;
            }
            node = node.children[chars[p]-'a'];
            p++;
        }
        return node.item.equals(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int p = 0;
        char [] chars = prefix.toCharArray();
        TrieNode node = root;
        while(p < chars.length) {
            if(node.children[chars[p]-'a'] == null) {
                return false;
            }
            node = node.children[chars[p]-'a'];
            p++;
        }
        return true;
    }
}

