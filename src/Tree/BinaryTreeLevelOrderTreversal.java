package Tree;

// ques: https://leetcode.com/problems/binary-tree-level-order-traversal/description/

import java.util.*;

public class BinaryTreeLevelOrderTreversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);


        while(!q.isEmpty()){
            int size = q.size();

            ans.add(q.stream().map(i->i.val).toList());

            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List <Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr= q.poll();
                level.add(curr.val);
                if(curr.left!=null)
                    q.offer(curr.left);

                if(curr.right!=null)
                    q.offer(curr.right);

            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTreversal binaryTreeLevelOrderTreversal = new BinaryTreeLevelOrderTreversal();
        List<List<Integer>> ans = binaryTreeLevelOrderTreversal.levelOrder(TreeNode.getTree());
        System.out.println(ans);
    }
}
