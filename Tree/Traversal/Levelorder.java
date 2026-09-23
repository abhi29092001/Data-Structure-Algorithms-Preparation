// TC -> O(n)
// SC -> O(n)

package Tree.Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Levelorder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        
        if (root != null) {
            q.offer(root); // adding root element in queue
        } else {
            return result;
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>();

            while (levelSize-- > 0) {
                TreeNode node = q.poll(); // removed front element
                temp.add(node.val); // added node's value in temp array

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            result.add(temp);
        }

        return result;
    }
}
