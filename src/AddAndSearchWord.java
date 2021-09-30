/**
 * You should design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) adds word to the data structure, it can be matched later.
 * bool search(word) returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 500
 * word in addWord consists lower-case English letters.
 * word in search consist of  '.' or lower-case English letters.
 * At most 50000 calls will be made to addWord and search .
 */
public class AddAndSearchWord {

    public static void main(String [] args) {

    }
}


class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = this.root;
        for(int i=0; i<word.length(); i++) {
            char temp = word.charAt(i);
            if(node.nodes[temp - 'a'] == null) {
                node.nodes[temp - 'a'] = new TrieNode();
            }
            node = node.nodes[temp - 'a'];
        }
        node.word = word;
    }

    public boolean search(String word) {
        TrieNode node = this.root;
        return dfs(0, word, node);
    }

    public boolean dfs(int index, String word, TrieNode node) {
        if(index == word.length()) return !node.word.equals("");
        char temp = word.charAt(index);
        if(temp != '.') {
            if(node.nodes[temp - 'a'] == null) return false;
            return dfs(index + 1, word, node.nodes[temp - 'a']);
        } else {
            for(int i=0; i<26; i++) {
                if(node.nodes[i] != null && dfs(index + 1, word, node.nodes[i])) {
                    return true;
                }
            }
            //either all possible char is false
            //or all node.nodes[i] == null
            return false;
        }
    }
}

class TrieNode {
    TrieNode [] nodes = new TrieNode[26];
    String word = "";
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 *
 *
 *
 */

/*
class WordDictionary {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();


public WordDictionary() { }


    public void addWord(String word) {
        //use a reference no manipulate the original root
        TrieNode node = this.root;
        char [] chars = word.toCharArray();
        for(char i : chars) {
            if(node.children[i-'a'] == null) {
                node.children[i-'a'] = new TrieNode();
            }
            node = node.children[i-'a'];
        }
        node.item = word;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    public boolean match(char [] chars, int index, TrieNode node) {
        if(index == chars.length) return !node.item.equals("");
        if(chars[index] != '.') {
            if(node.children[chars[index] - 'a'] != null) {
                return match(chars, index + 1, node.children[chars[index] - 'a']);
            }
            return false;
        } else {
            for(int i = 0; i<26; i++) {
                if(node.children[i] != null && match(chars, index + 1, node.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
 */