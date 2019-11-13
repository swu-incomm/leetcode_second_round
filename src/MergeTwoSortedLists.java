/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the
 first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1 != null && l2 != null) {
            int l1Val = l1.val;
            int l2Val = l2.val;
            head.next = (l1Val <= l2Val) ? l1 : l2;
            head = head.next;
            l1 = (l1Val <= l2Val) ? l1.next : l1;
            l2 = (l2Val < l1Val) ? l2.next: l2;
        }
        head.next = (l1 == null) ? l2 : l1;
        return temp.next;
    }

    public static void main(String [] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        a.next = b;
        b.next = c;
        d.next = e;
        e.next = f;
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        mergeTwoSortedLists.mergeTwoLists(a, d);

    }

}
