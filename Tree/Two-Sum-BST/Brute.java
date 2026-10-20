// TC -> O(n)
// SC -> O(n)

public class Brute {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            if (list.get(i) + list.get(j) == k) {
                return true;
            }
            else if (list.get(i) + list.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
