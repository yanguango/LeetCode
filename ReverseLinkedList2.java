/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        for (int i = 0; i < m - 1; i++) left = left.next;
        ListNode reversedHead = left.next;
        ListNode reversedTail = reversedHead;
        ListNode node = reversedHead.next;
        for (int i = 0; i < n - m; i++) {
            ListNode temp = node.next;
            node.next = reversedHead;
            reversedHead = node;
            node = temp;
        }
        left.next = reversedHead;
        reversedTail.next = node;
        return dummy.next;
    }
}
