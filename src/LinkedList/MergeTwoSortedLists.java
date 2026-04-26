package LinkedList;

// ques : https://leetcode.com/problems/merge-two-sorted-lists/description/

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode curr = ans;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curr.next=list1;
                list1 = list1.next;
            } else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1!=null)
            curr.next=list1;
        else
            curr.next=list2;

        return ans.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4,null)));

        MergeTwoSortedLists m = new MergeTwoSortedLists();
        m.mergeTwoLists(list1,list2);
    }
}
