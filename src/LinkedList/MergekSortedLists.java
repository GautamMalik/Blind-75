package LinkedList;

import java.util.Arrays;

// ques : https://leetcode.com/problems/merge-k-sorted-lists/description/

public class MergekSortedLists {

    public ListNode mergeKListsMyAnsBrute(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode ans = lists[0];
        for(int i=1; i<lists.length; i++){
            ans = mergeTwoSortedList(ans,lists[i]);
        }
        return ans;
    }

    public ListNode mergeKListsEfficient(ListNode[] lists) {
        if(lists.length==0)  // base case
            return null;
        if(lists.length==1) // basecase
            return lists[0];

        int  mid = lists.length/2;

        ListNode leftMerge = mergeKListsEfficient(Arrays.copyOfRange(lists, 0, mid));
        ListNode rightMerge = mergeKListsEfficient(Arrays.copyOfRange(lists, mid, lists.length));

        return mergeTwoSortedList(leftMerge,rightMerge);
    }

    private ListNode mergeTwoSortedList(ListNode list1, ListNode list2){
        ListNode ans = new ListNode();
        ListNode curr = ans;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1!=null)
            curr.next=list1;
        else
            curr.next = list2;

        return ans.next;
    }
}
