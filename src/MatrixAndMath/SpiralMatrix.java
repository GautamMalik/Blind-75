package MatrixAndMath;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return ans;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Top row
            for (int j = left; j <= right; j++)
                ans.add(matrix[top][j]);
            top++;

            // Right column
            for (int i = top; i <= bottom; i++)
                ans.add(matrix[i][right]);
            right--;

            // Bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    ans.add(matrix[bottom][j]);
                bottom--;
            }

            // Left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(matrix[i][left]);
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> ans = spiralMatrix.spiralOrder(new int[][]{
                {1, 2, 3,4},
                {5, 6, 7,8},
                {9, 10, 11,12}
//                {13, 14, 15, 16}
        });
        System.out.println(ans);
    }
}
