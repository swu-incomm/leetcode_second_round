
public class ImplementTrieII {
    class Trie {

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for(int i=0; i<word.length(); i++) {
                char temp = word.charAt(i);
                if(node.children[temp - 'a'] == null) {
                    TrieNode newNode = new TrieNode();
                    node.children[temp - 'a'] = newNode;
                }
                node = node.children[temp - 'a'];
            }
            node.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for(int i=0; i<word.length(); i++) {
                char temp = word.charAt(i);
                if(node.children[temp - 'a'] == null) {
                    return false;
                }
                node = node.children[temp - 'a'];
            }
            return node.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(int i=0; i<prefix.length(); i++) {
                char temp = prefix.charAt(i);
                if(node.children[temp - 'a'] == null) {
                    return false;
                }
                node = node.children[temp - 'a'];
            }
            return true;
        }
    }

    class TrieNode {
        boolean isWord;
        TrieNode [] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
