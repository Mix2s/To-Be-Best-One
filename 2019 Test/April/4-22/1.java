package src.com.shuihui.dao;

public class MinStack {
    private MyStack myStack;
    private MyStack minStack;
    public MinStack(){
        myStack = new MyStack();
        minStack = new MyStack();
    }
    public void push(int x){    
        myStack.push(x);            //存放数据的栈
        if(minStack.empty()){           //每一次存放最小值得栈
            minStack.push(x);
        }else{
            if(x<=minStack.peek()){
                minStack.push(x);
            }
        }
    }
    public void pop() {
        if (!myStack.empty()) {
            int tmp = myStack.pop();
            if (tmp == minStack.peek()) {
                minStack.pop();
            }
        }
    }    
    public int top(){
        if(myStack.empty()){
            return -1;
        }
        return myStack.peek();
    }
    public int getMin(){
        if(minStack.empty()){
            return -1;
        }
        return minStack.peek();
    }
}
