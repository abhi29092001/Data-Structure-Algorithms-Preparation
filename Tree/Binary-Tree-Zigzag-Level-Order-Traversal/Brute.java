// TC -> O(n)
// SC -> O(n)

public class Brute {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        boolean reverse = false;
        
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

            if (reverse) {
                Collections.reverse(temp);
            } 
            result.add(temp);
            reverse = !reverse;
        }

        return result;
    }
}
