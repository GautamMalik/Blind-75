package Tree;

// ques : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    // this is BST so use BST property

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if (p.val > root.val && q.val > root.val)
                root = root.right;
            else if (p.val < root.val && q.val < root.val)
                root = root.left;
            else
                return root;
        }
        return null;
    }

    /// //////////////////////////////////////////////////////////////
    ///
    /// brute force but good for binary tree Lowest common ancestor

    public TreeNode lowestCommonAncestorBruteForce(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        nodeToRootPath(root,p, path1);
        nodeToRootPath(root,q, path2);

        int i = path1.size()-1, j = path2.size()-1;
        while(i>=0 && j>=0){
            if(path1.get(i) != path2.get(j))
                break;
            i--; j--;
        }
        if(i==path1.size()-1)
            return null;
        else
            return path1.get(i+1);
    }

    private boolean nodeToRootPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if(root==null)
            return false;

        if(root.val == p.val){
            path.add(root);
            return true;
        }

        if(nodeToRootPath(root.left,p,path)){
            path.add(root);
            return true;
        }
        if(nodeToRootPath(root.right,p,path)){
            path.add(root);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LowestCommonAncestor l = new LowestCommonAncestor();
        TreeNode ans = l.lowestCommonAncestor(TreeNode.getBSTree(),new TreeNode(7),new TreeNode(9));
        System.out.println(ans);
    }
}
