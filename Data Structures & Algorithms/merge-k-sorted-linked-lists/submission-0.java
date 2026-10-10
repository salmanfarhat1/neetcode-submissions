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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for(int i =0; i < lists.length; i++){
           result = mergeTwoLists(result, lists[i]); 
        } 
        return result; 
    }
    public ListNode mergeTwoLists(ListNode cur1, ListNode cur2){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(cur1 != null && cur2 != null){
            while(cur1 != null && cur1.val <= cur2.val){
                cur.next = cur1; 
                cur = cur.next; 
                cur1 = cur1.next; 
            }
            if(cur1 == null)
                break; 
            while(cur2 != null && cur2.val < cur1.val){
                cur.next = cur2; 
                cur = cur.next; 
                cur2 = cur2.next; 
            }
        }
        if(cur1 != null)
            cur.next = cur1; 
        if(cur2 != null)
            cur.next = cur2; 
        return head.next;
    }
}
