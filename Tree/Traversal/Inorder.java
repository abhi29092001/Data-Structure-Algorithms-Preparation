// TC -> O(n)
// SC -> O(n)

package Tree.Traversal;

import java.util.ArrayList;
import java.util.List;

public class Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // left subtree traversal
        helper(node.left, result);

        // saving current node
        result.add(node.val);

        // right subtree traversal
        helper(node.right, result);
    }
}
