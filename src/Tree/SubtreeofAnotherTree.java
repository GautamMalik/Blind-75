package Tree;

// ques : https://leetcode.com/problems/subtree-of-another-tree/description/

import java.util.ArrayList;
import java.util.List;

public class SubtreeofAnotherTree {

    public boolean isSubtreeTheirSolution(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;

        if(root == null && subRoot != null)
            return false;

        if(isSameTree(root,subRoot))
            return true;

        boolean lst = isSubtreeTheirSolution(root.left, subRoot);
        boolean rst = isSubtreeTheirSolution(root.right, subRoot);

        return lst || rst;
    }

    /// ////////////////////////////////////////////////////////////

    private List<TreeNode> treeNodes = new ArrayList<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        findSubRoot(root,subRoot);
        for (TreeNode subRoot1 : treeNodes) {
            if(isSameTree(subRoot1, subRoot))
                return true;
        }
        return false;
    }

    private boolean isSameTree(TreeNode subRoot1, TreeNode subRoot) {
        if(subRoot1 == null && subRoot == null)
            return true;
        else if((subRoot1 == null && subRoot != null) || (subRoot1 != null && subRoot == null) || (subRoot1.val != subRoot.val))
            return false;

        if(!isSameTree(subRoot1.left, subRoot.left))
            return false;
        if(!isSameTree(subRoot1.right, subRoot.right))
            return false;

        return true;
    }

    private void findSubRoot(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return;

        if(root.val == subRoot.val)
            treeNodes.add(root);

        findSubRoot(root.left, subRoot);
        findSubRoot(root.right, subRoot);
    }


}
