package Graph;

// ques: https://leetcode.com/problems/pacific-atlantic-water-flow/description/

import java.util.*;

public class PacificAtlanticWaterFlow {


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];;
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];;

        List<List<Integer>> ans = new ArrayList<>();

        int rows = heights.length;
        int col = heights[0].length;

        for(int i=0; i<col; i++){
            dfs(0,i ,pacific, heights[0][i], heights);
            dfs(rows-1,i,atlantic,heights[rows-1][i],heights);
        }

        for(int i=0; i<rows; i++){
            dfs(i,0 ,pacific, heights[i][0], heights);
            dfs(i,col-1,atlantic,heights[i][col-1],heights);
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<col; j++){
                if(atlantic[i][j] && pacific[i][j])
                    ans.add(List.of(i,j));
            }
        }

        return ans;
    }

    private void dfs(int i, int j, boolean[][] visited, int prevHeight, int[][] heights) {
        if(i<0 || j<0 || i==heights.length || j==heights[0].length || heights[i][j] < prevHeight || visited[i][j])
            return;

        visited[i][j] = true;

        dfs(i-1, j, visited, heights[i][j], heights);
        dfs(i+1, j, visited, heights[i][j], heights);
        dfs(i, j-1, visited, heights[i][j], heights);
        dfs(i, j+1, visited, heights[i][j], heights);
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        List<List<Integer>> ans = pacificAtlanticWaterFlow.pacificAtlantic(new int[][]{
                {1,1},{1,1},{1,1}
        });
        System.out.println(ans);
    }
}
