package src.com.shuihui.dao;

import src.com.shuihui.impl.IMyStack;

public class MyStack implements IMyStack {
    private int[] elem;
    private int top; //保存当前可以存放数据的下标
    private int userSize;
    private static final int DEFAULT_SIZE=10;  //默认栈的容量

    public MyStack(){
        this.elem = new int[DEFAULT_SIZE];
        this.top=0;
        this.userSize=0;
    }

    public boolean isFull(){
       return this.top==this.elem.length;
    }
    //压栈
    @Override
    public void push(int item) {
       if(isFull()){
           throw  new UnsupportedOperationException("栈慢");
       }
       this.elem[this.top++]=item;
       this.userSize++;
       /*
        this.elem[top]=item;
        top++;
        */
    }

    //返回栈顶元素出栈
    @Override
    public int pop() {
        if(empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        int oldData=this.elem[this.top-1];
        --this.top;
        this.userSize--;
        return oldData;
    }
    //返回栈顶元素 不出栈
    @Override
    public int peek() {
        if(empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        this.userSize--;
        return this.elem[this.top-1];

    }
    //判断空栈
    @Override
    public boolean empty() {
        if(top<1){
            return false;
        }
        return true;
    }
    //返回元素个数
    @Override
    public int size() {
       return this.userSize;
    }

    public void display(){
        for (int i:elem) {
            System.out.print(this.elem[i]+" ");
        }
    }
}
