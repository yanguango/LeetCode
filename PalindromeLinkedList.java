/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode quick = head;
        ListNode slow = head;
        ListNode slowPrev = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        slowPrev.next = null;

        ListNode dummy = new ListNode(0);
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = temp;
        }
        ListNode n1 = head;
        ListNode n2 = dummy.next;
        while (n1 != null) {
            if (n1.val != n2.val) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}
