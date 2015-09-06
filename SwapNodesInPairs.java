/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode n1 = head;
        ListNode n2 = head.next;
        while (n1 != null && n2 != null) {
            ListNode next = n2.next;
            prev.next = n2;
            n2.next = n1;
            n1.next = next;
            prev = n1;
            n1 = next;
            if (n1 != null) n2 = n1.next;
        }
        return dummy.next;
    }
}
