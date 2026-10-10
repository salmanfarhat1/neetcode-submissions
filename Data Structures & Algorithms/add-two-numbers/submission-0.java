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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1; 
        ListNode cur2 = l2; 
        int reminder = 0; 
        ListNode head = new ListNode(-1);
        ListNode cur = head; 
        while(cur1 != null || cur2 != null || reminder == 1){
            int v1 = (cur1 == null) ? 0 :  cur1.val; 
            int v2 = (cur2 == null) ? 0 :  cur2.val; 
            int sum = reminder + v1 + v2; 
            if(sum >= 10)  reminder = 1;
            else reminder = 0; 
            sum = sum % 10; 

            ListNode node = new ListNode(sum); 
            cur.next = node; 
            cur = cur.next;
            if(cur1 != null) cur1 = cur1.next;
            if(cur2 != null) cur2 = cur2.next; 
        }
        return head.next; 
    }
}
