public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, "", res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, String word, List<String> res) {
        if (node == null || i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || board[i][j] == '#') return;

        char c = board[i][j];
        int index = c - 'a';
        if (node.list[index] != null && node.list[index].leaf) {
            res.add(word + c);
            node.list[index].leaf = false;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, node.list[index], word + c, res);
        dfs(board, i + 1, j, node.list[index], word + c, res);
        dfs(board, i, j - 1, node.list[index], word + c, res);
        dfs(board, i, j + 1, node.list[index], word + c, res);
        board[i][j] = c;
    }
}

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
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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
}
