package Tree;

// ques: https://leetcode.com/problems/validate-binary-search-tree/description/

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    // using bst property -> inorder treversal is in sorted order
    public boolean isValidBSTTheirSolution(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();

        helper(root,inOrder);
        for(int i=1; i< inOrder.size(); i++){
            if(inOrder.get(i-1) >= inOrder.get(i))
                return false;
        }
        return true;
    }

    private void helper(TreeNode root, List<Integer> inOrder) {
        if(root == null)
            return;
        helper(root.left,inOrder);
        inOrder.add(root.val);
        helper(root.right,inOrder);
    }

    /// ///////////////////////////////////////////////////////////

    class Pair {
        boolean isValidBST;
        long leftMaxValue;
        long rightMinValue;

        Pair(boolean isValidBST, long leftMaxValue, long rightMinValue) {
            this.isValidBST = isValidBST;
            this.leftMaxValue = leftMaxValue;
            this.rightMinValue = rightMinValue;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTDFS(root).isValidBST;
    }

    private Pair isValidBSTDFS(TreeNode root) {
        if (root == null)
            return new Pair(true, Long.MIN_VALUE, Long.MAX_VALUE);

        Pair lp = isValidBSTDFS(root.left);
        Pair rp = isValidBSTDFS(root.right);

        Pair pair = new Pair(lp.isValidBST && rp.isValidBST && root.val > lp.leftMaxValue && root.val < rp.rightMinValue,
                Math.max(root.val, Math.max(lp.leftMaxValue, rp.leftMaxValue)),
                Math.min(root.val, Math.min(lp.rightMinValue, rp.rightMinValue)));
        return pair;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode.printTree(TreeNode.getTree());
        boolean ans = validateBinarySearchTree.isValidBST(new TreeNode(2147483647));
        System.out.println(ans);
    }
}
