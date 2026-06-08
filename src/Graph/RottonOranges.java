package Graph;

// ques: https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

public class RottonOranges {

    private static class Pair {
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, col = grid[0].length;
        int fresh = 0;


        int ans = -1;
        boolean[][] visited = new boolean[rows][col];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2)
                    q.offer(new Pair(i,j));
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size ; i++){
                Pair temp = q.poll();
                if(temp.i < 0 || temp.i==rows || temp.j<0 || temp.j==col || visited[temp.i][temp.j] || grid[temp.i][temp.j] == 0)
                    continue;
                grid[temp.i][temp.j] = grid[temp.i][temp.j] + 1;
                visited[temp.i][temp.j] = true;
                q.offer(new Pair(temp.i-1, temp.j));
                q.offer(new Pair(temp.i+1, temp.j));
                q.offer(new Pair(temp.i, temp.j-1));
                q.offer(new Pair(temp.i, temp.j+1));
            }
            ans++;
        }

        if(fresh==0)
            return 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return --ans;
    }


    public static void main(String[] args) {
        RottonOranges rottonOranges  = new RottonOranges();
        int ans = rottonOranges.orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        });
        System.out.println(ans);
    }
}
