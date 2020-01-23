/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 * the solution will be let a faster point go further n steps and start a slow pointer to move
 * when faster pointer reaches the end, the slower one will be at nth to the tail
 * condition(fast==null)
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        ListNode prev = null;
        for(int i = 0; i<n;i++) fast = fast.next;
        while(fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if(prev == null) {
            return head.next;
        }
        prev.next = prev.next.next;
        return head;
    }
    public static void main(String [] args) {

    }
}
