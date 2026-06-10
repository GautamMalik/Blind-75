package Graph;

// ques : https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphCycle {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]){
                if (hasCycle(adj, visited, pathVisited, i))
                    return true;
            }
        }
        return false;
    }

    private boolean hasCycle(List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, int node) {
        visited[node] = true;
        pathVisited[node] = true;

        for(Integer neighbour : adj.get(node)){
            if(!visited[neighbour]){
                if(hasCycle(adj,visited,pathVisited,neighbour))
                    return true;
            } else if(pathVisited[neighbour])
                return true;
        }
        pathVisited[node] = false;
        return false;
    }

    public static void main(String[] args) {
        DirectedGraphCycle directedGraphCycle = new DirectedGraphCycle();
        directedGraphCycle.isCyclic(4,new int[][]{
                {0,1},{0,2},{1,2},{2,3}
        });
    }
}
