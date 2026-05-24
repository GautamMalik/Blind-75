package BackTracking;

// ques: https://leetcode.com/problems/sudoku-solver/

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean ans = dfs(board);
        if(ans)
            System.out.println("solved");
    }

    private boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (int val = 1; val < 10; val++) {
                        if (isSafeRow(i, val, board) && isSafeCol(j, val, board) && isSafeBox(i, j, val, board)){
                            board[i][j] = (char)(val + '0');
                            if (dfs(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        // if last element is getting filled means suduko solved hence returning true
        return true;
    }

    private boolean isSafeBox(int i, int j, int val, char[][] board) {
        int rowStart = (i / 3) * 3;
        int colStart = (j / 3) * 3;

        char ch = (char)(val + '0');

        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                if (board[r][c] == ch)
                    return false;
            }
        }
        return true;
    }

    private boolean isSafeCol(int j, int val, char[][] board) {
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == '.')
                continue;
            if (board[k][j] == (char)(val + '0'))
                return false;
        }
        return true;
    }

    private boolean isSafeRow(int i, int val, char[][] board) {
        for (int k = 0; k < board[0].length; k++) {
            if (board[i][k] == '.')
                continue;
            if (board[i][k] == (char)(val + '0'))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });

    }



}


