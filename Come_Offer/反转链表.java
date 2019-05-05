public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = null;  //创造一个结点表示 当前节点的前一个节点
        ListNode next = null;    //next 指向当前节点的下一个节点
        while(head!=null){ 
            next = head.next;          //next指向下一个节点
            head.next = pre;        //当前节点的next指向pre
            pre = head;            //将pre移 head
            head = next;
        }
        return pre;
    }
}
总结
    1.创建两个新的节点表示 当前节点前一个节点 与之后的节点
    2.让当前节点指向pre 移动 pre到head head移动到next next指向当前下一个
