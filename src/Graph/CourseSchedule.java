package Graph;

// ques: https://leetcode.com/problems/course-schedule/description/

import java.util.ArrayList;
import java.util.List;

// find cycle in directed graph

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]){
                if (hasCycle(adj, visited, pathVisited, i))
                    return false;
            }
        }
        return true;
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

}
