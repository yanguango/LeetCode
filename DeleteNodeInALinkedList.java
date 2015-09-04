/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        ListNode current = node;
        ListNode after = node.next;
        while (after != null) {
            current.val = after.val;
            after = after.next;
            if (after == null) {
                current.next = null;
            } else {
                current = current.next;
            }
        }
    }
}
