/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode node = new ListNode(0);
        ListNode cur = new ListNode(0);
        cur=node;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                cur=cur.next;
                l1=l1.next;
            }else{
                cur.next=l2;
                cur=cur.next;
                l2=l2.next;
            }
            
        }
        if(l1==null){
            cur.next=l2;
        }else{
            cur.next=l1;
        }
    return node.next;
}
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = new ListNode(0);
        fast=head;
        ListNode slow = new ListNode(0);
        slow=head;
        while(fast!=null){
            if(fast==fast.next){
                return true;
            }
            slow=fast.next;
            fast.next=fast;
            fast=slow;
        }
        return false;
    }
}
