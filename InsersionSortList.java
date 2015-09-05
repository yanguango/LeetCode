/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsersionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode sortedTail = dummy;
        ListNode current = head;
        while (current != null) {
            ListNode node = dummy;
            while (node != sortedTail && node.next.val < current.val) {
                node = node.next;
            }
            if (node.next == null) sortedTail = current;
            ListNode next = current.next;
            ListNode temp = node.next;
            node.next = current;
            current.next = temp;
            current = next;
        }
        return dummy.next;
    }
}
