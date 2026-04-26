package LinkedList;

// ques : https://leetcode.com/problems/middle-of-the-linked-list/description/

public class MiddleoftheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fast=head, slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,null)));
        MiddleoftheLinkedList m = new MiddleoftheLinkedList();
        System.out.println(m.middleNode(listNode).val);
    }
}
