package MatrixAndMath;

// ques: https://leetcode.com/problems/set-matrix-zeroes/

import java.util.Arrays;

public class SetMatrixZeroes {

    /*
            Brute Force -
              iterate over matrix and if zero found then mark its entire row and column as -1

              iterate again in matrix and mark -1 as 0

     */

    public void setZeroes(int[][] matrix) {

        int firstRow = 1, firstColumn = 1;

        for(int i=0; i< matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    if (i == 0)
                        firstRow = 0;
                    else
                        matrix[i][0] = 0;

                    if (j == 0)
                        firstColumn = 0;
                    else
                        matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i< matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(firstRow==0){
            for(int i=0; i<matrix[0].length; i++){
                matrix[0][i] =0;
            }
        }

        if(firstColumn==0){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] =0;
            }
        }
    }

    public void setZeroesBetterThanBrute(int[][] matrix) {

        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for(int i=0; i< matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0; i< matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(row[i] == 1 || col[j]==1)
                    matrix[i][j]=0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(new int[][]{
                {0,1,2,0},
                {3,4,0,2},
                {1,3,1,5}
        });
    }
}
