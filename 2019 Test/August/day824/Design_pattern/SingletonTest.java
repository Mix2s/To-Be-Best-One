package main.Design_pattern;

import java.util.Stack;

public class SingletonTest {
    public static void main(String[] args) {
       int[] a = new int[]{1,2,3,4,5};
       int[] b = new int[]{4,5,3,2,1};
        System.out.println(IsPopOrder(a,b));
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<pushA.length;i++){
            if(stack.size()==0){
                stack.push(pushA[i]);
            }else if(stack.peek()!=popA[i]){
                stack.push(pushA[i]);
            }
            if(stack.peek()==popA[i]){
                stack.pop();
            }
        }

        if(stack.size()!=0){
            return false;
        }
        return true;
    }
}
