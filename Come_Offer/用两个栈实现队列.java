import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            return 0;
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
思路：
    1.栈的准则 先进后出 队列先进先出
    2.所以用两个栈，现将其中一个栈压数据 然后弹栈 的数据存入第二个栈
    3.从第二个栈 完成数据的弹出达到 队列的先进先出
