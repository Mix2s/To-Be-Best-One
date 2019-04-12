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
//找出链表的回环点
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head==null){
            return null;
        }
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast.next==null||fast.next.next==null||head==null){
            return null;
        }
            fast=head;
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
         return fast;
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
   
 public ListNode detectCycle(ListNode head) {
     
   ListNode fast = head;
       
 ListNode slow = head;
       
 boolean has = false;
        
if(head==null){
           
 return null;
        
}
       
 while(fast.next!=null&&fast.next.next!=null){
  
          slow=slow.next;
       
     fast=fast.next.next;
         
   if(fast==slow){
       
         has=true;
          
      break;
         
   }
      
  }
        
if(has){
      
      ListNode q = head;
     
       while(slow!=q){
      
          slow=slow.next;
     
           q=q.next;
       
     }
         
   return q;
     
   }else{
        
    return null;
   
     }
   
 }

}

//两条链表的相交点
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null||headB==null){
                return null;
            }
        ListNode cur = headB;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=headB;
        ListNode fast = headA;
        ListNode slow = headA;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                ListNode node  = headA;
                while(node!=fast){
                    node=node.next;
                    fast=fast.next;
                }
                cur.next=null;
                return node;
            }
        }
        cur.next=null;
        return null;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null||headB==null){
                return null;
            }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1!=p2){
            p1=(p1==null)?headB:p1.next;
            p2=(p2==null)?headA:p2.next;
        }
        return p1;
    }
}
