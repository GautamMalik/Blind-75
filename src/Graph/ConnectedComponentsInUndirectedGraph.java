package Graph;

// ques : https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1

import java.util.ArrayList;

public class ConnectedComponentsInUndirectedGraph {

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i: edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i]){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(adj, visited, i, comp);
                ans.add(comp);
            }
        }

        return ans;

    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i, ArrayList<Integer> comp) {
        visited[i] = true;
        comp.add(i);
        for(Integer neighbour : adj.get(i)){
            if(!visited[neighbour]){
                dfs(adj, visited, neighbour,comp);
            }
        }
    }

    public static void main(String[] args) {
        ConnectedComponentsInUndirectedGraph connectedComponentsInUndirectedGraph = new ConnectedComponentsInUndirectedGraph();
        ArrayList<ArrayList<Integer>> ans = connectedComponentsInUndirectedGraph.getComponents(5, new int[][]{
                {0, 1}, {2, 1}, {3, 4}
        });
        System.out.println(ans);
    }


}
