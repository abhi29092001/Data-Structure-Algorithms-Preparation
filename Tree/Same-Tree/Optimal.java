// TC -> O(n)
// SC -> O(h)

public class Optimal {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        if (p.val != q.val) return false;

        boolean result1 = isSameTree(p.left, q.left);
        boolean result2 = isSameTree(p.right, q.right);

        if (result1 && result2) return true;
        return false;
    }
}
