/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-101);
        ListNode cur = head; 
        ListNode cur1 = list1; 
        ListNode cur2 = list2; 

        while(cur1 != null &&  cur2!=null){
            while(cur1 != null && cur1.val <= cur2.val){
                cur.next = new ListNode(cur1.val); 
                cur = cur.next; 
                cur1 = cur1.next; 
            }
            if(cur1 == null)
                break; 
             while(cur2 != null && cur2.val < cur1.val){
                cur.next = new ListNode(cur2.val); 
                cur = cur.next; 
                cur2 = cur2.next; 
            }
        }       

        if(cur1 != null)
            cur.next =cur1;
        if(cur2 != null)
            cur.next = cur2; 

        return head.next; 
    }
}


/*Notes: 


*/ 