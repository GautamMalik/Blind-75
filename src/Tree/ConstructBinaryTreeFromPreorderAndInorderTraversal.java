package Tree;

// ques : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       Map<Integer,Integer> inMap = new HashMap<>();
       for(int i=0; i<inorder.length; i++)
           inMap.put(inorder[i],i);
       return helper(preorder, 0, preorder.length-1, inorder,0, inorder.length-1, inMap);

    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd && inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = helper(preorder, preStart + 1, numsLeft, inorder, inStart, inRoot-1, inMap);
        root.right = helper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }


}
