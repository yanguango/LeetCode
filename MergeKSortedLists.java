/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(final ListNode n1, final ListNode n2) {
                return Integer.compare(n1.val, n2.val);
            }
        });
        for (ListNode node : lists)
            if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) heap.offer(node.next);
        }
        return dummy.next;
    }
}
