import java.util.ListIterator;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode temp = node2;
        ListNode temp1 = node1;
        while(head != null) {
            if(head.val<x) {
                node1.next = new ListNode(head.val);
                node1 = node1.next;
            } else {
                node2.next = new ListNode(head.val);
                node2 = node2.next;
            }
            head = head.next;
        }
        temp1 = temp1.next;
        if(temp1 == null) return temp.next;
        node1.next = temp.next;
        return temp1;
    }
}
