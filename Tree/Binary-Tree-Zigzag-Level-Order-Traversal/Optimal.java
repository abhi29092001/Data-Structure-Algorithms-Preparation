// TC -> O(N)
// SC -> O(N)

public List<List<Integer>> Optimal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        boolean leftToRight = true;
        
        if (root != null) {
            q.offer(root); // adding root element in queue
        } else {
            return result;
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>(Collections.nCopies(levelSize, 0));
            int first = 0;
            int last = levelSize - 1;

            while (levelSize-- > 0) {
                TreeNode node = q.poll(); // removed front element
                
                // adding node's val in temp array based on level whether its L-R or R-L
                if (leftToRight) {
                    temp.set(first, node.val);
                    first++;
                } else {
                    temp.set(last, node.val);
                    last--;
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            result.add(temp);
            leftToRight = !leftToRight;
        }

        return result;
}