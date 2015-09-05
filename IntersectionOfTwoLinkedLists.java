/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode na = headA;
        ListNode nb = headB;
        while (na != null && nb != null) {
            na = na.next;
            nb = nb.next;
        }
        if (na == null) {
            ListNode temp = nb;
            nb = headB;
            while (temp != null) {
                temp = temp.next;
                nb = nb.next;
            }
            na = headA;
        } else if (nb == null) {
            ListNode temp = na;
            na = headA;
            while (temp != null) {
                temp = temp.next;
                na = na.next;
            }
            nb = headB;
        }

        while (na != nb) {
            na = na.next;
            nb = nb.next;
        }
        return na;
    }
}
