package BackTracking;

import java.util.Arrays;

public class UniquePaths {
    private int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0,0,m-1,n-1);
    }

    private int dfs(int i, int j, int m, int n) {

        if(i==m && j ==n)
            return 1;

        if(i>m || j>n)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int down = dfs(i+1,j,m,n);
        int right = dfs(i,j+1,m,n);
        return dp[i][j] = down+right;
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,7));
    }
}
