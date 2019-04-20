
class MyQueue {
    private Stack<Object> real = null;
    private Stack<Object> temp = null;
    /** Initialize your data structure here. */
    public MyQueue() {
        real= new Stack<>();
        temp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {  
        real.push(x);   //进入队列使用Stack的压栈操作
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {      //pop() 返回队列元素 出队列 这个元素从队列消失
        int i=0;
        while(!real.empty()){         //当real不为空 也就是队列中存放元素
            temp.push(real.peek());   //将real中的所有元素弹出 弹出的元素按照逆序存放进入temp栈中 这里可以使用 temp.push(real.pop());
            real.pop();         
        }
        i = (int)temp.pop();      //此时在temp顶元素就是real的最底下的元素 也就是第一次存入的元素将其弹出消除
        while(!temp.empty()){
            real.push(temp.peek());   //执行完所有的操作将temp中的元素 返回real
            temp.pop();
        }
        return i;
    }
        
    
    /** Get the front element. */
    public int peek() {
         int i=0;//拿出队列元素 出队列
        while(!real.empty()){
            temp.push(real.peek());
            real.pop();
        }
        i = (int)temp.peek();       //其他部分与上相同 此时不是 弹出消除 是弹出不消除
        while(!temp.empty()){
            real.push(temp.peek());
            temp.pop();
        }
        return i;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return real.empty(); 
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 
 总结：
    1.利用的栈的先进先出使用两个栈完成队列的操作
