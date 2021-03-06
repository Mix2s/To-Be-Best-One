public class Solution {
    int[] stack = new int[1024];
    int top=0;
    public void push(int node) {
        if(top==0){
            stack[0]=node;
            stack[1]=node;
            top+=2;
        }else{
          if(node<stack[top-1]){
              stack[top]=node;
              top++;
              stack[top]=node;
              top++;
          }else{
              stack[top]=node;
              top++;
              stack[top]=stack[top-2];
              top++;
          }
        }
    }
    
    public void pop() {
        if(top==0){
            return;
        }
        stack[top--]=0;
        stack[top--]=0;
    }
    
    public int top() {
        return stack[top-2];
    }
    
    public int min() {
        return stack[top-1];
    }
}
总结
  1.使用时采用数组模拟栈 利用top 每次向数组中压入两个数字 第一个为原本的数字 第二个为最小的值
  2.在压入一个新的数字 与之前的栈顶元素进行比较 比它大正常压入 比他小在压入数字之后 压入当前数字
public class Solution {
    Stack<Integer> dataStack = new Stack();
    Stack<Integer> minStack = new Stack();
    
    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty()||node<minStack.peek()){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
总结
   1.使用两个栈解决 第一个栈存放数据第二个栈存放当前所有数字的最小值栈
