/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode insertPos = dummy;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.val >= x) {
                prev = current;
                current = current.next;
            } else if (current.val < x && insertPos == prev) {
                prev = current;
                current = current.next;
                insertPos = insertPos.next;
            } else {
                ListNode next = current.next;
                prev.next = current.next;
                current.next = insertPos.next;
                insertPos.next = current;
                current = next;
                insertPos = insertPos.next;
            }
        }
        return dummy.next;
    }
}
