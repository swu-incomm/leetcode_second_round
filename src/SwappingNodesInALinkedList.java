/**
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and
 * the kth node from the end (the list is 1-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 * Example 3:
 *
 * Input: head = [1], k = 1
 * Output: [1]
 * Example 4:
 *
 * Input: head = [1,2], k = 1
 * Output: [2,1]
 * Example 5:
 *
 * Input: head = [1,2,3], k = 2
 * Output: [1,2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */
import java.util.*;
public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || k < 1 ) return null;
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        //swap in list
        int t1 = list.get(k-1);
        list.set(k-1, list.get(list.size()-k));
        list.set(list.size()-k, t1);
        temp = head;
        for(int i=0; i<list.size(); i++) {
            temp.val = list.get(i);
            temp = temp.next;
        }
        return head;
    }
}
