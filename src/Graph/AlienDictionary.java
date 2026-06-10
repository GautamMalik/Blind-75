package Graph;

// ques: https://www.geeksforgeeks.org/problems/alien-dictionary/1

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();

        // adding node to adj list
        for(String word : words){
            for (char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new ArrayList<>());
            }
        }

        // making graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());

            boolean foundDifference = false;

            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    foundDifference = true;
                    break;
                }
            }
            if (!foundDifference && w1.length() > w2.length())
                return "";
        }

        String ans = "";
        int[] indegree = new int[26];
        Queue<Character> q = new LinkedList<>();

        // making indegree arr
        for(Character key : adj.keySet()){
            for(Character it :adj.get(key)){
                indegree[it - 'a']++;
            }
        }

        for(Character key : adj.keySet()){
            if(indegree[key - 'a']==0)
                q.offer(key);
        }

        int count = 0;
        while(!q.isEmpty()){
            Character ch = q.poll();
            ans += ch;
            count++;

            for(Character neighbour : adj.get(ch)){
                indegree[neighbour - 'a']--;
                if(indegree[neighbour - 'a']==0)
                    q.offer(neighbour);
            }
        }

        // means cycle exist
        if (count != adj.size())
            return "";

        return ans;
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        alienDictionary.findOrder(new String[]{"ab", "cd", "ef", "ad"});
    }
}
