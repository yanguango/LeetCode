/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> next = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty() || !next.isEmpty()) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) next.offer(node.left);
            if (node.right != null) next.offer(node.right);

            if (queue.isEmpty()) {
                if (count % 2 == 1) {
                    Collections.reverse(level);
                }
                res.add(level);
                level = new ArrayList<Integer>();
                Deque<TreeNode> temp = queue;
                queue = next;
                next = temp;
                count++;
            }
        }
        return res;
    }
}