public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
         ListNode last = pHead2;
        while(last.next!=null){
            last=last.next;
        }
        last.next=pHead2;
        ListNode fast=pHead1;
        ListNode slow=pHead1;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode p = pHead1;
                while(p!=slow){
                    p=p.next;
                    slow=slow.next;
                }
                last.next=null;
                return p;
            }
        }
         last.next=null;
        return null;
    }
}
思路：
    1.先对传入的两个链表进行判断
    2.将第二个链表为尾节点连向头意义上 将两个链表拼在一起 然后进行 快慢指针  
     
    public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
       if(pHead1==null||pHead2==null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1=(p1==null)?pHead1:p1.next;
            p2=(p2==null)?pHead2:p2.next;
        }
        return p1;
 }
 思路：
    1.对两个链表进行交互遍历操作 相同时拿出
