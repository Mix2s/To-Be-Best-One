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

    @Override
    public int remove(int key) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void removeAllKey(int key) {
        // TODO Auto-generated method stub


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

        }
        while(node!=null) {
            System.out.println(node.data+"");
            node=node.next;
        }
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }


}
