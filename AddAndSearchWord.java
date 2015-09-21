public class WordDictionary {
    private Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.search(word);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] list;
    public boolean leaf;
    public TrieNode() {
        list = new TrieNode[26];
        leaf = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void add(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.list[index] == null) {
                current.list[index] = new TrieNode();
            }
            current = current.list[index];
        }
        current.leaf = true;
    }
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.leaf;
        boolean res = false;
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                res = res || dfs(word, index + 1, node.list[i]);
            }
        } else {
            int next = word.charAt(index) - 'a';
            if (node.list[next] == null)
                return false;
            else
                res = dfs(word, index + 1, node.list[next]);
        }
        return res;
    }
}
