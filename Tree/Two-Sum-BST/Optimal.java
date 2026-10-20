// TC -> O(n)
// SC -> O(h)

public class Optimal {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        pushLeft(root, leftStack);
        pushRight(root, rightStack);

        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode leftNode = leftStack.peek();
            TreeNode rightNode = rightStack.peek();

            if (leftNode == rightNode) return false;

            int sum = leftNode.val + rightNode.val;

            if (sum == k) return true;
            else if (sum < k) {
                TreeNode curr = leftStack.pop();
                pushLeft(curr.right, leftStack);
            } else {
                TreeNode curr = rightStack.pop();
                pushRight(curr.left, rightStack);
            }
        }

        return false;
    }

    public void pushLeft(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public void pushRight(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }
}
