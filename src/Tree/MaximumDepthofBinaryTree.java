package Tree;

// ques : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);

        return Math.max(ld,rd) + 1;
    }
}
