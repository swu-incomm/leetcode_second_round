/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    /**
    //the solution is to use divide and conquer method, divide list are two parts recursively
   // and merge two list layer by layer
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return l.next;
    }
     **/
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while(fast != null  && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(node1 != null && node2!= null) {
            if(node1.val > node2.val) {
                dummy.next = node2;
                node2 = node2.next;
            } else {
                dummy.next = node1;
                node1 = node1.next;
            }
            dummy = dummy.next;
        }
        if(node2 != null) {
            dummy.next = node2;
        }
        if(node1 != null) {
            dummy.next = node1;
        }
        return temp.next;
    }
}
