// TC -> O(n)
// SC -> O(h)

public class Optimal {
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    public int helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;

        int left = helper(root.left, p, q);   
        int right = helper(root.right, p, q);   

        int self = 0;
        if (root == p || root == q) self = 1;

        int total = left + right + self;
        if (total == 2 && result == null) result = root;

        return total;
    }
}
