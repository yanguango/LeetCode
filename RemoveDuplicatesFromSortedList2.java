/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n1 = dummy;
        while (n1.next != null) {
            ListNode n2 = n1.next;
            while (n2.next != null && n2.next.val == n2.val) {
                ListNode temp = n2;
                n2 = n2.next;
                temp.next = null;
            }
            if (n1.next == n2) {
                n1 = n1.next;
            } else {
                n1.next = n2.next;
                n2.next = null;
            }

        }
        return dummy.next;

    }
}
