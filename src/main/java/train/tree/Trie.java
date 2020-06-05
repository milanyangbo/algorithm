package train.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class Trie {

  public static void main(String[] args) {
    String[] words = new String[] {"oath", "pea", "eat", "rain"};
    char[][] board =
        new char[][] {
          {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        };
    List<String> result = new Trie().findWords(board, words);
  }

  public List<String> findWords(char[][] board, String[] words) {
    for (String word : words) {
      insert(word);
    }
    Set<String> set = new TreeSet();
    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        backtrack(board, visited, "", i, j, set);
      }
    }

    return new ArrayList<>(set);
  }

  private void backtrack(
      char[][] board, boolean[][] visited, String str, int x, int y, Set<String> set) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
    if (visited[x][y]) return;

    str += board[x][y];
    if (!startsWith(str)) return;

    if (search(str)) {
      set.add(str);
    }
    visited[x][y] = true;
    backtrack(board, visited, str, x - 1, y, set);
    backtrack(board, visited, str, x + 1, y, set);
    backtrack(board, visited, str, x, y - 1, set);
    backtrack(board, visited, str, x, y + 1, set);
    visited[x][y] = false;
  }

  TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
    root.val = ' ';
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode wc = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (wc.children[c - 'a'] == null) {
        TrieNode node = new TrieNode();
        node.val = c;
        wc.children[c - 'a'] = node;
      }
      wc = wc.children[c - 'a'];
    }
    wc.isWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode wc = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (wc.children[c - 'a'] == null) {
        return false;
      } else {
        TrieNode node = wc.children[c - 'a'];
        wc = node;
      }
    }
    if (wc.isWord) {
      return true;
    }
    return false;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode wc = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (wc.children[c - 'a'] == null) {
        return false;
      } else {
        TrieNode node = wc.children[c - 'a'];
        wc = node;
      }
    }
    return true;
  }

  static class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
  }
}
