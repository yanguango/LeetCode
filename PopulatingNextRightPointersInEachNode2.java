/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode2 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Deque<TreeLinkNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode prev = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                if (prev != null) prev.next = node;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                prev = node;
            }
        }
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode nextLevelStart = root;
        TreeLinkNode previous = null;
        while (nextLevelStart != null) {
            TreeLinkNode parent = nextLevelStart;
            nextLevelStart = null;
            previous = null;
            while (parent != null) {
                if (nextLevelStart == null) nextLevelStart = parent.left;
                if (nextLevelStart == null) nextLevelStart = parent.right;
                previous = connectNodes(previous, parent.left);
                previous = connectNodes(previous, parent.right);
                parent = parent.next;
            }
        }
    }

    public TreeLinkNode connectNodes(TreeLinkNode previous, TreeLinkNode next) {
        if (previous != null) previous.next = next;
        return next == null ? previous : next;
    }
}
