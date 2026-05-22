package Tree;

// ques : https://leetcode.com/problems/same-tree/description/

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if((p == null && q != null) || (p != null && q == null) || (p.val != q.val))
            return false;

        if(!isSameTree(p.left, q.left))
            return false;
        if(!isSameTree(p.right, q.right))
            return false;

        return true;
    }
}
