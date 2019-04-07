package src.com.shuihui.dao;

import src.com.shuihui.impl.IDoubleLinked;

public class DoubleLinkedimpl implements IDoubleLinked {
    class Node {
        private int data;
        private Node prev;      //前驱
        private Node next;      //后继

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node last;      //标志单链表的尾巴
    public DoubleLinkedimpl(){
        this.head=null;
        this.last=null;
    }
    @Override
    public void addFirst(int data) {
        //第一次插入
        Node node = new Node(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            node.next=this.head;
            node.next.prev=node;  //next 的前驱就是自己本身
            this.head=node;
        }

    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head==null){
            this.last=node;
            this.head=node;
        }else{
            this.last.next=node;
            node.prev=this.last;        //this.last 尾节点 标记的尾节点
            this.last=node;
        }
    }


    private void checkIndex(int index){
        if(index<0||index>getLength()){
            throw new IndexOutOfBoundsException("下表不合法");
        }
    }
    private Node searchIndex(int index){
        checkIndex(index);
        Node cur = this.head;
        int count=0;
        while(count<index){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    @Override
    public boolean addindex(int index, int data) {
        Node node = new Node(data);
        Node cur = searchIndex(index);  //目标插入位置
         if(index==0){
            addFirst(data);
            return true;
         }
         if(index==getLength()){
            addLast(index);
            return true;
         }

            node.next=cur;
            cur.prev.next=node;
            node.prev=cur.prev;
            cur.prev=node;
            return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur!=null){
            if(cur.next.data==key){
                return true;
            }else{
                cur=cur.next;
            }
        }
        return false;
    }

    @Override
    public int remove(int key) {
        Node cur = this.head;
        int oldData=0;
        while(cur!=null){
            if(cur.data==key){
                //当删除头结点
                if(cur==this.head){
                    this.head=this.head.next;
                    this.head.prev=null;
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null) {
                        cur.next.prev = cur.prev;
                    }else{  //最后一个节点
                        this.last=cur.prev;
                    }
                }
                return oldData;
            }
            cur=cur.next;
        }
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        //不返回 全部执行一遍 将所有的符合情况的删除
        Node cur = this.head.next;
        while(cur!=null){
            if(cur.data==key){
                //当删除头结点
                if(cur==this.head){
                    this.head=this.head.next;
                    this.head.prev=null;
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null) {
                        cur.next.prev = cur.prev;
                    }else{  //最后一个节点
                        this.last=cur.prev;
                    }
                }
            }
            cur=cur.next;
        }
    }

    @Override
    public int getLength() {
        Node cur = this.head;
        int count=0;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node node = this.head;
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head!=null){
            Node cur = this.head.next;
            head.prev=null;
            head.next = null;
            head=cur;
        }
        this.last=null;
    }
}
