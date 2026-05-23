package Tree;

// ques : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

public class SerializeAndDeserializeBinaryTree {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializeHelper(root);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root) {
        if(root==null) {
            sb.append("n,");
            return;
        }

        sb.append(root.val+",");
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")
            return null;
        String[] arr = data.split(",",-1);
        return deserializeHelper(arr);
    }
    int i=-1;
    private TreeNode deserializeHelper(String[] arr) {
        i++;
        if(i>= arr.length)
            return null;
        if(arr[i].equals("n"))
            return null;

        TreeNode treeNode = new TreeNode(Integer.parseInt(arr[i]));
        treeNode.left = deserializeHelper(arr);
        treeNode.right = deserializeHelper(arr);
        return treeNode;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        String serializedString = s.serialize(TreeNode.getTree());
        System.out.println(serializedString);
        s.deserialize(serializedString);
    }
}
