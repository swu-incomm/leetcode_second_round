/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode cur = head;
        while(left > 1) {
            left --;
            right--;
            prev = cur;
            cur = cur.next;
        }
        ListNode connect1 = prev;
        ListNode connect2 = cur;
        while(right > 0) {
            right--;
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        if(connect1 != null) {
            connect1.next = prev;
        } else {
            //in this case, the head will change to the first of remaining list node
            //which is cur
            head = prev;
        }
        connect2.next =cur;
        return head;
    }

    public static void main(String [] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node1.next = node2;
        ReverseLinkedListII re = new ReverseLinkedListII();
        re.reverseBetween(node1, 1, 2);
        String a = "3animals";
        System.out.println(a.indexOf("3"));
    }
}
