package LinkedList;

// ques : https://leetcode.com/problems/reorder-list/

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode mid = getMiddleNode(head);
        ListNode reversedHead = reverseSecondHalf(mid);
        merge(head,reversedHead);
    }

    private void merge(ListNode head, ListNode reversedHead){
        ListNode left = head, right = reversedHead;
        while(right.next!=null){
            ListNode temp1 = left.next;
            ListNode temp2 = right.next;
            left.next=right;
            right.next=temp1;

            left = temp1;
            right=temp2;
        }
    }

    private ListNode reverseSecondHalf(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev = null, curr = head, next = head.next;
        while(next!=null){
            curr.next = prev;
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next = prev;
        return curr;
    }

    private ListNode getMiddleNode(ListNode head){
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ReorderList m = new ReorderList();
        m.reorderList(listNode);
    }
}
