package Tries;

// ques: https://leetcode.com/problems/implement-trie-prefix-tree/description/

import java.util.HashMap;

public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        Trie2 trie2 = new Trie2();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("ball");
        trie.insert("ac");

        System.out.println(trie.search("app")); // true
        System.out.println(trie.search("a"));   // false

        trie2.insert("apple");
        trie2.insert("app");
        trie2.insert("ball");
        trie2.insert("ac");

        System.out.println(trie2.search("app")); // true
        System.out.println(trie2.search("a"));
    }

    private static class TrieNode {
        boolean flag = false;
        TrieNode[] links = new TrieNode[26];

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        void insert(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }

        TrieNode get(char ch) {
            return links[ch - 'a'];
        }
    }

    private static class Trie {

        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode temp = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!temp.containsKey(ch))
                    temp.insert(ch, new TrieNode());

                temp = temp.get(ch);
            }

            temp.setEnd();
        }

        public boolean search(String word) {
            TrieNode temp = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!temp.containsKey(ch))
                    return false;

                temp = temp.get(ch);
            }

            return temp.isEnd();
        }

        public boolean startsWith(String prefix) {
            TrieNode temp = root;

            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (!temp.containsKey(ch))
                    return false;

                temp = temp.get(ch);
            }

            return true;
        }
    }

    /// /////////////////////////////////////////////////////
    ///
    /// Their solution

    private static class TrieNode2 {
        HashMap<Character, TrieNode2> children;
        boolean isEnd;

        public TrieNode2() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    private static class Trie2{

        private TrieNode2 root;

        Trie2() {
            root = new TrieNode2();
        }

        public void insert(String word) {
            TrieNode2 temp = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!temp.children.containsKey(ch))
                    temp.children.put(ch, new TrieNode2());

                temp = temp.children.get(ch);
            }

            temp.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode2 temp = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!temp.children.containsKey(ch))
                    return false;

                temp = temp.children.get(ch);
            }

            return temp.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode2 temp = root;

            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (!temp.children.containsKey(ch))
                    return false;

                temp = temp.children.get(ch);
            }
            return true;
        }
    }
}