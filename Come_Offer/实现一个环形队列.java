package src.com.shuihui.dao;
/*
    循环队列 采用数组的方式实现
 */
class MyCircularQueue {
    private int front;
    private int rear;
    private int[] elem;
    private int userSize;       //有效数据的大小

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.elem = new int[k];   //不加一 此时浪费一个格子
        this.front = 0;
        this.rear = 0;
        this.userSize = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {     //入队
        if(isFull()){
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear+1)%this.elem.length;
        this.userSize++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {          //出队
        if(isEmpty()){
            return false;
        }
        int data = this.elem[this.front];
        this.front = (this.front+1)%this.elem.length;
        this.userSize--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {            //获得队首元素
        if(isEmpty()){
            throw new UnsupportedOperationException("为空");
        }
        int data = this.elem[this.front];
        return  data;
    }

    /** Get the last item from the queue. */
    public int Rear() {                 //获得队尾元素
        if(isEmpty()){
            throw new UnsupportedOperationException("为空");
        }
        if(this.rear==this.elem.length-1){
            return this.elem[this.elem.length-1];
        }
        return this.elem[this.rear-1];
        //return this.elem[this.rear==this.elem.length-1？this.elem.length-1:this.rear-1]
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {              //判空
        //return this.front==this.rear;
        return this.userSize==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {               //判满
        if((this.rear+1)%this.elem.length ==this.front){         //浪费数组一个元素用来表示最后一个位置 采用这种方式找满
            return true;
        }
        return false;
    }
}
