package com.shuihui.dao;

import com.shuihui.impl.ISequence;
import java.util.Arrays;

public class SequenceImpl implements ISequence {
    //对象引用数组
    private Object[] elemDate;
    //索引记数
    private int userSize;
    //初始静态数组长度
    public static final int DEFAULT_CAPACTIY=10;

    void SequenceImple(){
        this.elemDate=new Object[DEFAULT_CAPACTIY];
        this.userSize=0;
    }

    private boolean isFull(){
        return this.userSize==this.elemDate.length;
    }
    @Override
    public boolean add(int pos, Object data) {
        //判断pos的合法性 放入数据是否会放生溢出
        if(pos<0||pos>this.userSize){
            return false;
        }
        if(isFull()){
            //数组扩容
            this.elemDate= Arrays.copyOf(this.elemDate,
                    this.elemDate.length*2);

        }
        //挪数据
        int key=this.userSize-1;
        for(int i=key;i>=pos;i--){
            this.elemDate[i+1]=this.elemDate[i];
        }
        //放入数据 userSized
        this.elemDate[pos]=data;
        this.userSize++;
        return true;
    }


    //判断当前顺序表为空
    private boolean isEmpty(){
        return this.userSize==0;
    }
    @Override
    public int search(Object key) {
        if(key==null){
            throw new UnsupportedOperationException("不可传入参数");
        }

        if(isEmpty()){
            return -1;
        }

        for(int i=0;i<this.userSize;i++){
            if(this.elemDate[i].equals(key)){               //引用数据类型是否相等使用equals
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(key==null){
            throw new UnsupportedOperationException("不可传入参数");
        }
        if(isEmpty()){
            throw  new UnsupportedOperationException("数组为空");
        }
        for(int i=0;i<this.userSize;i++){
            if(this.elemDate[i].equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos<0||pos>=this.userSize){
            return null;
        }
        return this.elemDate[pos];
    }

    @Override
    public Object remove(Object key) {
        int index = search(key);
        if(index==-1){
            return false;
        }
        Object originalData = this.elemDate[index];
        int i=0;
        for(i=index;i<this.userSize-1;i++){
            this.elemDate[i]=this.elemDate[i+1];
        }
        this.elemDate[i+1]=null;
        this.userSize--;
        return originalData;
    }

    public Object removeAll(Object key){
        return null;
    }

    @Override
    public int size() {
        return this.userSize;
    }

    @Override
    public void display() {
        for(int i=0;i<this.userSize;i++){
            System.out.println(this.elemDate[i]);
        }
    }

    @Override
    public void clear() {
        for(int i=0;i<this.userSize;i++){
            this.elemDate[i]=null;
        }
        this.userSize=0;
    }
}
