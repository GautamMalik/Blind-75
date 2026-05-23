package Tree;

// ques : https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class BinaryTreeMaximumPathSum {
    private int maxi = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxSum(root);
        return maxi;
    }

    private int maxSum(TreeNode root) {
        if(root == null)
            return 0;

        int leftSum = Math.max(0,maxSum(root.left)); // like kadane algo if value is -ve then start again
        int rightSum =Math.max(0, maxSum(root.right));

        maxi = Math.max(maxi, leftSum + rightSum + root.val);
        return Math.max(leftSum,rightSum) + root.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        TreeNode.printTree(TreeNode.getTree());
        binaryTreeMaximumPathSum.maxPathSum(TreeNode.getTree());
    }

}
