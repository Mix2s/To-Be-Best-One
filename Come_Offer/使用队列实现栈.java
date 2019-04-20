class MyStack {
    private Queue que1;         //定义两个队列
    private Queue que2;
    /** Initialize your data structure here. */
    public MyStack() {
        que1 = new LinkedList();
        que2 = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {           //实现压栈操作
        if(que1.peek()!=null){          //判断队列是否为空
            while(que1.peek()!=null){      //为什么循环拿出每一个元素存放在 2种   要使用队列满足栈操作 在存放时元素时候 要将每一个
                que2.add(que1.poll());     //新元素存放在队列的头 才能实现 先进后出 后进先出的 栈操作
            }
            que1.add(x);          //将新元素存放在第一个位置 再将之前的元素重新放入
            while(que2.peek()!=null){
                que1.add(que2.poll());
            }
        }else{
            que1.add(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(que1.peek()==null){
            return 0;
        }
        return (int)que1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if(que1.peek()==null){
            return 0;
        }
        return (int)que1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(que1.peek()==null){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
