package Graph;

// ques: https://leetcode.com/problems/clone-graph/

import java.util.*;

public class CloneGraph {

    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Integer, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        map = new HashMap<>();
        Node ans = new Node(node.val);
        map.put(node.val, ans);
        dfs(ans, node);
        return ans;
    }

    private void dfs(Node root, Node node) {
        for(Node n : node.neighbors){
            if(!map.containsKey(n.val)) {
                Node clonedNode = new Node(n.val);
                map.put(n.val,clonedNode);
                root.neighbors.add(clonedNode);
                dfs(clonedNode, n);
            }
            else
                root.neighbors.add(map.get(n.val));
        }

    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        cloneGraph.cloneGraph(cloneGraph.buildGraph());
    }


    private Node buildGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        return node1;
    }
}
