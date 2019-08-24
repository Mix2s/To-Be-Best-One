package main.sequence;

import java.util.ArrayList;
import java.util.Arrays;

public class SequenceImpl  implements ISequence{
    private Object[] elem;
    private int userSize;
    public static final int DEFAULT_LENGTH = 10;

    public SequenceImpl(){
        this.elem = new Object[DEFAULT_LENGTH];
        this.userSize = 0;
    }

    public boolean isFull(){
        return this.userSize==this.elem.length;
    }
    @Override
    public boolean add(int pos, Object data) {
        if(pos<0||pos>this.userSize){
            return false;
        }
       if(isFull()){
           //数组扩容
           this.elem =
                   Arrays.copyOf(this.elem,this.elem.length*2);
       }
       int key = this.userSize-1;
       for(int i=key;i>=pos;i--){
           this.elem[i+1] = this.elem[i];
       }
       //放入数据
        this.elem[pos] = data;
       this.userSize++;
       return true;
    }

    public void add(int data){
        if(isFull()){
            //数组扩容
            this.elem =
                    Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.userSize++] = data;
    }

    private boolean isEmpty(){
        return this.userSize==0;
    }
    @Override
    public int search(Object key) {
        if(key==null){
            throw new UnsupportedOperationException("不可传入null");
        }
        if(isEmpty()){
            return -1;
        }
        for(int i=0;i<this.userSize;i++){
            if(this.elem[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(key==null){
            throw new UnsupportedOperationException("不可传入null");
        }
        if(isEmpty()){
            return false;
        }
        for(int i=0;i<this.userSize;i++){
            if(this.elem[i].equals(key)){
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
        return this.elem[pos-1];
    }

    @Override
    public Object remove(Object key) {
        int index =search(key);
        if(index==-1){
            return false;
        }
        Object originalData = this.elem[index];
        int i = 0;
        for(i=index;i<this.userSize-1;i++){
            this.elem[i] = this.elem[i+1];
        }
        this.elem[i+1] = null;
        this.userSize--;
        return originalData;
    }

    @Override
    public int size() {
        return this.userSize;
    }

    @Override
    public void display() {
        for(int i=0;i<this.userSize;i++){
            System.out.print(this.elem[i]+" ");
        }
    }

    @Override
    public void clear() {
        for(int i=0;i<this.userSize;i++){
            this.elem[i] = null;
        }
        this.userSize = 0;
    }
}
