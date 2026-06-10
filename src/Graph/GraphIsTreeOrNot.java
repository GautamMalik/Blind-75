package Graph;

import java.util.ArrayList;
import java.util.List;

// ques : https://www.geeksforgeeks.org/problems/is-it-a-tree/1

public class GraphIsTreeOrNot {
    public int isTree(int n, int m, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];

        if(hasCycle(adj,0, -1, visited))
            return 0;

        // if all nodes visited or not
        for(int i=0; i<n; i++){
            if(!visited[i])
                return 0;
        }
        return 1;
    }

    private boolean hasCycle(List<List<Integer>> adj, int node, int parent, boolean[] visited) {

        visited[node] = true;

        for(Integer neightbour : adj.get(node)){
            if(!visited[neightbour]){
                if(hasCycle(adj, neightbour, node, visited))
                    return true;
            } else if (neightbour != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        GraphIsTreeOrNot graphIsTreeOrNot = new GraphIsTreeOrNot();
        graphIsTreeOrNot.isTree(4,3,new int[][]{
                {0,1},{1,2},{1,3}
        });
    }
}
