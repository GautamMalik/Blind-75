package LinkedList;

// ques : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);
        ListNode left = dummy, right = head;
        while(n>0){
            right=right.next;
            n--;
        }

        while(right!=null){
            right=right.next;
            left=left.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
