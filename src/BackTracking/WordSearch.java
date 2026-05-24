package BackTracking;

// ques: https://leetcode.com/problems/word-search/description/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean val = dfs(board, word, visited, i, j, 0);
                    if(val) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j,int wordIdx) {
        if(wordIdx==word.length())
            return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(wordIdx) || visited[i][j])
            return false;

        visited[i][j] = true;

        boolean found =
                dfs(board, word, visited, i, j + 1, wordIdx + 1) ||
                        dfs(board, word, visited, i, j - 1, wordIdx + 1) ||
                        dfs(board, word, visited, i + 1, j, wordIdx + 1) ||
                        dfs(board, word, visited, i - 1, j, wordIdx + 1);

        visited[i][j] = false;
        return found;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        wordSearch.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "SEE");
    }
}
