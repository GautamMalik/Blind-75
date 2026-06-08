package Graph;

// ques: https://leetcode.com/problems/number-of-islands/description/

public class NumberOfIslands {

    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i,j,grid);
                    ans++;

                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, char[][] grid) {
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || visited[i][j] || grid[i][j] == '0')
            return;

        visited[i][j] = true;
        dfs(i+1,j,grid); // down
        dfs(i-1,j,grid); // up
        dfs(i,j+1,grid); // right
        dfs(i,j-1,grid); // left
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        numberOfIslands.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        });
    }
}
