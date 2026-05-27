package Tries;

// ques: https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("apple");
        trie.addWord("cat");
        System.out.println(trie.search(".at"));
    }

    private static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    private static class Trie{

        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode temp = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!temp.children.containsKey(ch))
                    temp.children.put(ch, new TrieNode());

                temp = temp.children.get(ch);
            }

            temp.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode temp = root;
            return dfs(temp, 0, word);
        }

       private boolean dfs(TrieNode node, int idx, String word){
            if(idx == word.length())
                return node.isEnd;

            char c = word.charAt(idx);
            if(c == '.'){
                for(TrieNode children : node.children.values()){
                    if(dfs(children, idx+1, word))
                        return true;
                }
            }
            if(node.children.containsKey(c)){
                if(dfs(node.children.get(c),idx+1,word))
                    return true;
            }
            return false;
       }
    }
}
