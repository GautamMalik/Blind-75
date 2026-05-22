package Tree;

// ques : https://leetcode.com/problems/invert-binary-tree/description/

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if(root==null)
            return null;

        TreeNode ln = invertTree(root.left);
        TreeNode rn = invertTree(root.right);

        root.right = ln;
        root.left= rn;

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode.printTree(invertBinaryTree.invertTree(TreeNode.getTree()));

    }


}
