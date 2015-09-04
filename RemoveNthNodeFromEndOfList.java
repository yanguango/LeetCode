/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode quick = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n + 1; i++) quick = quick.next;
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        ListNode after = slow.next.next;
        slow.next = after;
        return dummy.next;
    }
}
