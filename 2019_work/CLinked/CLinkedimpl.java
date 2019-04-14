package src.com.shuihui.dao;

import src.com.shuihui.impl.ICLinked;
//带头的循环单链表
public class CLinkedimpl implements ICLinked {
    class Node{
        private Node next;
        private int data;

        public Node(){
            this.data=-1;

        }

        public Node(int data){
            this.data=data;
        }
    }

    private Node head;

    public CLinkedimpl(){
        this.head=new Node();
        this.head.next=this.head;
    }


    @Override
    public void addFirst(int data) {
        Node node  = new Node(data);
        node.next = this.head.next;
        this.head.next=node;
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next!=this.head){
            cur = cur.next;
        }
        node.next=this.head;
        cur.next=node;
    }

    private void checkIndex(int index){
        if(index<0||index>getLength()){
            throw new IndexOutOfBoundsException("下标不合法");
        }
    }
    @Override
    public boolean addIndex(int index, int data) {
        Node node  = new Node(data);
        Node cur = this.head;
        checkIndex(index);
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next=node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur.next!=this.head){
            if(cur.next.data==key){
                return true;
            }else{
                cur=cur.next;
            }
        }
        return false;
    }

    private Node searchPre(int key){
        Node pre = this.head;
        while(pre.next!=this.head){
            if(pre.next.data==key){
                return pre;
            }else{
                pre=pre.next;
            }
        }
        return null;
    }
    @Override
    public int remove(int key) {
        int oldData=0;
        Node pre = searchPre(key);
        if(pre==null){
            System.out.print("无该节点");
        }

        oldData = pre.next.data;
        pre.next=pre.next.next;
        /**
         * Node delNode = pre.next;
         * oldData = delNode.data;
         * pre.next = delNdoe.next;
         */
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        int oldData = 0;
        Node pre = this.head;
        Node cur = this.head.next;
        while(cur!=this.head){
           if(cur.data==key){
               pre.next=cur.next;
               cur=cur.next;
           }else{
               cur=pre;
               cur=cur.next;
           }
        }
    }

    @Override
    public int getLength() {
        Node node = this.head.next;
        int count = 0;
        while(node!=this.head){
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node node = this.head.next;
        while(node!=this.head){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head.next!=this.head){
            Node cur = this.head.next;
            this.head.next=cur.next;
            cur.next=null;
        }
    }
}
