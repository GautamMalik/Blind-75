package BackTracking;

import java.util.*;

public class RatInAMaze {
    public ArrayList<String> ratInMaze(int[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze.length];
        ArrayList<String> ans = new ArrayList<>();
        dfs(maze, visited, 0,0,"",ans);
        return ans;
    }

    private void dfs(int[][] maze, boolean[][] visited, int i, int j, String path, ArrayList<String> ans) {
        if(i<0 || i>= maze.length || j<0 || j>=maze.length || visited[i][j] || maze[i][j] == 0)
            return;

        if(i== maze.length-1 && j== maze.length-1) {
            ans.add(path);
            return;
        }

        visited[i][j] = true;

        dfs(maze, visited, i + 1, j, path + "D", ans);
        dfs(maze, visited, i, j - 1, path + "L", ans);
        dfs(maze, visited, i, j + 1, path + "R", ans);
        dfs(maze, visited, i - 1, j, path + "U", ans);

        visited[i][j] = false;
    }


    public static void main(String[] args) {
        RatInAMaze ratInAMaze = new RatInAMaze();
        System.out.println(ratInAMaze.ratInMaze(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        }));
    }
}
