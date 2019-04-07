package src.com.shuihui.dao;

import src.com.shuihui.impl.ILinked;

public class Linkedimpl implements ILinked {
    private Node head;
    class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }

    @Override
    public void addFirst(int data) {
        // TODO Auto-generated method stub
        //第一次插入数据
        Node node = new Node(data);
        if(this.head==null) {
            this.head=node;
        }else {
            node.next=this.head;
            this.head=node;
        }
    }

    @Override
    public void addLast(int data) {
        // TODO Auto-generated method stub
        Node node = new Node(data);
        Node cur = this.head;
        if(cur==null) {
            this.head=node;
        }else {
            while(cur.next!=null) {
                cur=cur.next;
            }
            cur.next=node;
        }
    }

    //寻找index -1 位置的节点
    private Node serchIndex(int index) {
        checkIndex(index);
        //记录从头到尾的步数
        int count=0;
        if(index==0){
        return null;
     }
    Node cur = this.head;
        while(cur.next!=null&&count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    private void checkIndex(int index) {
        if(index<0||index>getLength()) {
            throw new IndexOutOfBoundsException("下标不合法");
        }
    }
    @Override
    public boolean addindex(int index, int data) {
        // TODO Auto-generated method stub
        Node node = new Node(data);
        Node cur = serchIndex(index);
        if(cur==null){
            node.next=this.head;
            this.head=node;
        }else{
            node.next=cur.next;
            cur.next=node;
        }
        return true;
    }

    //判断是否有元素
    @Override
    public boolean contains(int key) {
        // TODO Auto-generated method stub
       Node node  = this.head;
       while(node!=null){
           if(node.data==key){
               return true;
           }else{
               node=node.next;
           }
       }
       return false;
    }

    private Node searchPre(int key){
        //判断是不是第一个节点
        Node cur = this.head;           //创建头结点
        if(head.data==key){            //如果头结点符合情况 返回头结点
            return cur;
        }
            //找到符合key节点的前一个节点
            while(cur.next!=null){          //将整个链表从头到尾遍历 结束是最后一个next=null
                if(cur.next.data==key){
                    return cur;
                }else{
                    cur=cur.next;               //不符合情况则下一个
                }
            }
        return null;
    }
    @Override
    public int remove(int key) {
        // TODO Auto-generated method stub
        int oldData = 0;
        Node pre = searchPre(key);          //找到符合情况的前一个节点
        if(pre==null){
            throw new UnsupportedOperationException("无节点");
        }
       if(pre==this.head&&pre.data==key){               //排除当目标节点为第二个节点时 前一节点为head
           oldData=this.head.data;          //拿到数据存放
           this.head=this.head.next;
           return oldData;
       }
       Node delNode=pre.next;               //拿到前一个节点next节点
       oldData = delNode.data;
       pre.next = delNode.next;             //与目标节点下一个节点相连接
       return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        // TODO Auto-generated method stub
       Node cur = this.head.next;           //pre cur   curNdext cur
       Node pre = this.head;
       while(cur!=null){
           if(cur.data==key){
                pre.next=cur.next;
                cur=pre.next;
           }else{
               pre=cur;
               cur=pre.next;
           }
       }
       if(this.head.data==key){
           this.head=this.head.next;
       }
     }



    @Override
    public int getLength() {
        // TODO Auto-generated method stub
        int len=0;
        Node node = this.head;
        while(node!=null) {
            len++;
            node=node.next;
        }
        return len;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        Node node = this.head;
        if(node==null){
            System.out.println("wudi");
        }
        while(node!=null) {
            System.out.print(node.data+" ");
            node=node.next;
        }
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
       while(this.head.next!=null){
           Node cur = this.head.next;
           this.head= null;
           this.head = cur;
       }
    }

    public Node middleNode(Node head){
        Node node = new Node(0);
        for(int i=0;i<getLength()/2;i++){
            node=node.next;
        }
        return node;
    }

    public Node findKthToTail(int k){
        Node fast = this.head;
        Node slow = this.head;
        if(fast==null&&k<=0||k>=getLength()){
            return null;
        }
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
       while(fast!=null){
           fast=fast.next;
           slow=slow.next;
       }
       return slow;
    }

    public Node partition(int x){
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node pHead = this.head;
        while(pHead!=null){
            Node cur=pHead.next;
            pHead.next=null;
            if(pHead.data<x){
                if(bs==null){
                    bs=pHead;
                    be=pHead;
                }else{
                    be.next=pHead;
                    be=be.next;
                }
            }
            if(pHead.data>x){
                if(as==null){
                    as=pHead;
                    ae=pHead;
                }else{
                    ae.next=pHead;
                    ae = ae.next;
                }
            }
            pHead=cur;
        }
        if(bs==null){
            return as;
        }
        be.next=as;
        return bs;
    }
}
