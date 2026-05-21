package MatrixAndMath;

public class RotateImage {

    // need to do without extra space
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i=0; i<=n/2; i++){
            for(int j=i; j< n-i-1; j++){

                int temp = matrix[i][j];

                // swapping bottom left to top left
                matrix[i][j] = matrix[n-1-j][i];

                // bottom right to bottom left
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];

                // top right to bottom right
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];

                // temp to top right
                matrix[j][n-1-i] = temp;

            }
        }
    }

    // use extra space
    public void rotateBruteForce(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix.length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                ans[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        r.rotate(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
    }
}
