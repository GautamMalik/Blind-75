package LinkedList;

import java.util.Stack;

// ques : https://leetcode.com/problems/reverse-linked-list/description/

public class ReverseLinkedList {
    public ListNode reverseListBruteForce(ListNode head) {
        if(head == null)
            return null;
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();

        while(curr != null){
            stack.push(curr);
            curr=curr.next;
        }
        ListNode ans = stack.pop(); curr=ans;
        while(!stack.isEmpty()){
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next=null;
        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ReverseLinkedList m = new ReverseLinkedList();
        System.out.println(m.reverseList(listNode).val);
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode prev=null, curr = head, next = head.next;
        while(next!=null){
            curr.next = prev;
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        return curr;
    }
}
