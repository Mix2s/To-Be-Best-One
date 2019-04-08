/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head.next;
        ListNode pre = head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
                cur=pre.next;
            }else{
                pre=cur;
                cur=pre.next;
            }
        }
        if(head.val==val){
            head=head.next;
        }
         return pre;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode len = head;
        while(len!=null){
            len=len.next;
            count++;
        }
        ListNode node = head;
        for(int i=0;i<count/2;i++){
            node = node.next;
        }
        return node;
    }
}

