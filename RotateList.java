/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode node = head;
        int length = 1;
        while (node != null && node.next != null) {
            length++;
            node = node.next;
        }

        node.next = head;
        for (int i = 0; i < length - k % length; i++) {
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }
}
