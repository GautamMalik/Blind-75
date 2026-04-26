package LinkedList;

import java.util.HashSet;
import java.util.Set;

// ques : https://leetcode.com/problems/linked-list-cycle-ii/description/

public class LinkedListCycleII {
    public ListNode detectCycleMySolutionButWorstThanBruteForce(ListNode head) {
        ListNode temp = head;
        while(temp!=null){
            if(hasCycleAtHead(temp))
                return temp;
            temp=temp.next;
        }
        return null;
    }

    private boolean hasCycleAtHead(ListNode head){
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(head== slow || head == fast)
                return true;
            if(fast==slow)
                return false;
        }
        return false;
    }

// -----------------------------------------------------------------------------

    public ListNode detectCycleBruteForceOne(ListNode head) {
        Set<ListNode> set = new HashSet();
        ListNode temp=head;
        while(temp!=null){
            if(set.contains(temp))
                return temp;
            set.add(temp);
            temp=temp.next;
            // System.out.println(set);
        }
        return null;
    }

// -----------------------------------------------------------------------------

    public ListNode detectCycle(ListNode head) {
        ListNode slow = hasCycle(head), fast = head;
        if(slow == null)
            return null;

        while(true){
            if(fast==slow)
                return fast;
            fast = fast.next;
            slow = slow.next;
        }
    }

    public ListNode hasCycle(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return slow;
        }
        return null;
    }
}
