// TC -> O(n)
// SC -> O(h)

public class Optimal {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null && node2 != null || node1 != null && node2 == null) return false;
        if (node1.val != node2.val) return false;

        boolean res1 = helper(node1.left, node2.right);
        boolean res2 = helper(node1.right, node2.left);

        if (res1 && res2) return true;

        return false;
    }
}
