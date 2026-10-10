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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null ) return head;

        ListNode cur = head.next;
        ListNode prev = head; 
        prev.next = null; 
        
        while(cur != null){
            ListNode curNext = cur.next; 
            cur.next = prev; 
            prev= cur; 
            cur = curNext; 
        }

        return prev; 
    }
}


/*Notes: 
1 2 3 4

prev = 1 
cur 2 
curNext = 3 
cur,ncet - prev 
re

*/ 