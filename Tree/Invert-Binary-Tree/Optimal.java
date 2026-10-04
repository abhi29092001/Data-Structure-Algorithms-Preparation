// TC -> O(n)
// SC -> O(h)

public class Optimal {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        
        // swapping left and right child nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
