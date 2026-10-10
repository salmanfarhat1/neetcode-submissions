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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet(); 
        ListNode cur = head; 
        while(cur != null){
            if(cur.val == 2000)
                return true; 
                
            cur.val = 2000;
            cur = cur.next;
        } 
        return false;
    }
}
