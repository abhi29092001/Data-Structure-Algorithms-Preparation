// TC -> O(h)
// SC -> O(h)

public class Recursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (
            (root.val == p.val || root.val == q.val) ||
            (root.val > p.val && root.val < q.val) ||
            (root.val < p.val && root.val > q.val)
        ) {
            return root;
        }

        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
}
