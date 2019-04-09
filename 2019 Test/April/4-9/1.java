/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//. 输入一个链表，输出该链表中倒数第k个结点。
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
            ListNode pre = head;
            ListNode cur = head;
                int key=k;
                int count=0;
            while(cur!=null){
                cur=cur.next;
                count++;
            if(k<1){
                pre=pre.next;
                }
                k--;
            }
           if(count<key){
            return null;
            }
        return pre;
        }
 }


/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//. 输入一个链表，输出该链表中倒数第k个结点。
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        if(head==null||k<=0){
           return null;
        }
        for(int i=1;i<k;i++){
          if(fast.next!=null){
              fast=fast.next;
          }else{
              return null;
          }
        }
       while(fast.next!=null){
           fast = fast.next;
           slow = slow.next;
       }
        return slow;
 }
}


import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
// 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        if(pHead==null){
            return pHead;
        }
        ListNode small = new ListNode(-1);
        ListNode shead = small;
        ListNode big = new ListNode(-1);
        ListNode bhead = big;
        ListNode cur = pHead;
        while(cur!=null){
            if(cur.val<x){
                small.next = cur;
                small = small.next;
            }else{
                big.next = cur;
                big=big.next;
            }
            cur=cur.next;
        }
        small.next=bhead.next;
        big.next=null;
        return shead.next;
    }
}



/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
//重复的结点不保留，返回链表头指针。 
public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode header = new ListNode(0);
        header.next=pHead;
        ListNode pre = header;
        ListNode cur = header.next;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=pre.next;
                cur=cur.next;
            }
        }
        return header.next;
    }
}
