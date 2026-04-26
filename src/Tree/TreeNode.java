package Tree;

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public TreeNode getTree(){
          TreeNode treeNode = new TreeNode(4);
          treeNode.left = new TreeNode(2,new TreeNode(1),new TreeNode(3));
          treeNode.right = new TreeNode(7,new TreeNode(6),new TreeNode(9));
          return treeNode;
      }
  }
