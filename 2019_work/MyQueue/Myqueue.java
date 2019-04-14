package src.com.shuihui.dao;

import src.com.shuihui.impl.IMyQueue;

public class MyQueue implements IMyQueue {

    class Node{
        private Node next;
        private int data;

        public Node(int data) {
            this.data=data;
        }
    }
    private Node front; //存放队列的头
    private Node rear;  //存放队列的尾
    private int userSize;   //计算链表存放元素的元素个数

    public MyQueue(){
        this.rear=null;
        this.front=null;
        this.userSize=0;
    }
    // 判断这个队列是否为空
    @Override
    public boolean empty() {
       return this.userSize==0;
    }
    // 返回队首元素，但不出队列
    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }
    // 返回队首元素，并且出队列
    @Override
    public int poll() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int data = this.front.data;
        this.front=this.front.next;           //删除头结点
        userSize--;
        return data;
    }
    // 将 item 放入队列中
    @Override
    public void add(int item) {
        Node node = new Node(item);
        if(empty()){
            this.rear=node;                 //当为空时第一个节点 为头为尾
            this.front=node;
        }
        rear.next=node;                 //尾节点的next指向 node
        rear=rear.next;                 //再把引用指向尾
        userSize++;
    }
    // 返回元素个数
    @Override
    public int size() {
        return userSize;
    }

    public void display(){
        Node cur = new Node(0);
        cur=this.front;
        for (int i = 0; i < userSize; i++) {
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
}
