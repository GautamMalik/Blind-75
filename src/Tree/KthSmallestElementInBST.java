package Tree;

// ques : https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

import java.util.*;

public class KthSmallestElementInBST {

    // BST property -> inorder = sorted list
    public int kthSmallestTheirSolution(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorderTreversal(root, inorder);
        if(k>inorder.size())
            return -1;
        else
            return inorder.get(k-1);

    }

    private void inorderTreversal(TreeNode root, List<Integer> inorder) {
        if(root == null)
            return;
        inorderTreversal(root.left,inorder);
        inorder.add(root.val);
        inorderTreversal(root.right,inorder);
    }


    // Better for BT
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        helper(root, pq);
        int ans = -1;
        for(int i=1; i<=k; i++){
            if(pq.isEmpty())
                return -1;
            ans = pq.poll();
        }
        return ans;
    }

    private void helper(TreeNode root, Queue<Integer> pq) {
        if(root == null)
            return;
        pq.offer(root.val);
        helper(root.left,pq);
        helper(root.right,pq);
    }
}
