// TC -> O(n)
// SC -> O(n)

public class Optimal {
    // whole code is same as of level order traversal except last line where reversal is required in this problem
    
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new ArrayDeque<>();

        if (root != null) {
            q.offer(root);
        } else {
            return result;
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>();

            while (levelSize-- > 0) {
                TreeNode node = q.poll();
                temp.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                } 

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            result.add(temp);
        }

        Collections.reverse(result);
        return result;
}
