package Tries;

// ques: https://leetcode.com/problems/word-search-ii/description/

import java.util.*;

public class WordSeach2 {

    private Set<String> ans = new HashSet<>();

    private static class TrieNode{
        boolean isEnd;
        HashMap<Character,TrieNode> children;

        TrieNode(){
            this.isEnd = false;
            this.children = new HashMap<>();
        }
    }

    private static class Trie{
        private TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        private void insert(String word){
            TrieNode node = root;
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(!node.children.containsKey(ch))
                    node.children.put(ch,new TrieNode());
                node = node.children.get(ch);
            }
            node.isEnd = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words)
            trie.insert(word);
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(trie.root.children.containsKey(board[i][j])){
                    TrieNode node = trie.root;
                    dfs(board,node,i,j,visited,new StringBuilder());

                }
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, TrieNode root, int i, int j, boolean[][] visited, StringBuilder tempAns) {
        if(root.isEnd)
            ans.add(tempAns.toString());

        if(i<0 || j<0 || i>= board.length || j>=board[0].length || visited[i][j] || !root.children.containsKey(board[i][j]))
            return;


        visited[i][j] = true;
        tempAns.append(board[i][j]);
        dfs(board,root.children.get(board[i][j]),i+1,j,visited,tempAns);
        dfs(board,root.children.get(board[i][j]),i,j+1,visited,tempAns);
        dfs(board,root.children.get(board[i][j]),i-1,j,visited,tempAns);
        dfs(board,root.children.get(board[i][j]),i,j-1,visited,tempAns);
        visited[i][j] = false;
        tempAns.deleteCharAt(tempAns.length()-1);
    }


    /// //////////////////////////////////////////////////////////////////

    ///  Will show TLE as O(words.length * m * n * dfs)
    public List<String> findWords2(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        List<String> ans = new ArrayList<>();
        boolean flag = false;
        for(String word : words){
            for(int i=0; i<board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (dfs2(board,word,i,j,visited,0)) {
                            ans.add(word);
                            flag=true;
                            break;
                        }
                    }
                }
                if(flag) {
                    flag=false;
                    break;
                }
            }
        }
        return ans;
    }

    private boolean dfs2(char[][] board, String word, int i, int j, boolean[][] visited, int charIdx) {
        if(charIdx==word.length())
            return true;
        if(i<0 || j<0 || i>= board.length || j>=board[0].length || visited[i][j] || board[i][j] != word.charAt(charIdx))
            return false;

        visited[i][j] = true;
        boolean ans = dfs2(board,word,i+1,j,visited,charIdx+1) ||
                dfs2(board,word,i,j+1,visited,charIdx+1) ||
                dfs2(board,word,i-1,j,visited,charIdx+1) ||
                dfs2(board,word,i,j-1,visited,charIdx+1);
         visited[i][j] = false;
         return ans;
    }

    public static void main(String[] args) {
        WordSeach2 wordSearch = new WordSeach2();
        wordSearch.findWords(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, new String[]{"SEE","SE"});
    }
}
