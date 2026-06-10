package Graph;

// ques: https://leetcode.com/problems/count-the-number-of-complete-components/description/

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfCompleteComponents {

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] t : edges){
            adj.get(t[0]).add(t[1]);
            adj.get(t[1]).add(t[0]);
        }

        boolean[] visited = new boolean[n];
        List<List<Integer>> components = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!visited[i]){
                List<Integer> comp = new ArrayList<>();
                dfs(adj, visited, i, comp);
                components.add(comp);
            }
        }
        int ans = 0;
        for(List<Integer> comp : components){
            if(isCompleteComp(adj,comp))
                ans++;
        }

        return ans;
    }


    // every node must have neighbour  = no. of node in that component -1
    private boolean isCompleteComp(List<List<Integer>> adj, List<Integer> comp) {
        for(Integer i : comp){
            if(adj.get(i).size() != comp.size()-1)
                return false;
        }
        return true;
    }


    private void dfs(List<List<Integer>> adj, boolean[] visited, int node, List<Integer> comp) {
        visited[node] = true;
        comp.add(node);

        for(Integer neighbour : adj.get(node)){
            if(!visited[neighbour])
                dfs(adj,visited,neighbour,comp);
        }
    }

    public static void main(String[] args) {
        CountNumberOfCompleteComponents countNumberOfCompleteComponents = new CountNumberOfCompleteComponents();
        int ans = countNumberOfCompleteComponents.countCompleteComponents(4, new int[][]{
                {0, 1},{0,2},{3,1},{3,2}
        });
        System.out.println(ans);
    }
}
