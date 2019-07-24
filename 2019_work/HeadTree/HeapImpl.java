package main.tree;

import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;

public class HeapImpl implements Heap{
    private int[] elem;
    private int userSize;
    private static final int DEFAULT_SIZE  = 10;

    public HeapImpl() {
        this.userSize = 0;
        this.elem = new int[DEFAULT_SIZE];
    }

    @Override
    public void AdjustDown(int root, int len) {
        int parent = root;
        int child = 2*parent+1;
        while(child<len){
            if(child+1<len){
                if(elem[child]<elem[child+1]){
                    child++;
                }
                if(elem[child]>elem[parent]){
                    int tmp = elem[parent];
                    elem[parent] = elem[child];
                    elem[child] = tmp;
                    parent = child;
                    child = 2*parent+1;
                }else{
                    break;
                }
            }
        }
    }

    @Override
    public void initHeap(int[] array) {
        for(int i=0;i<array.length;i++){
            elem[i] = array[i];
            this.userSize++;
        }

        //开始调整 每一颗子树 都需要调整
        for(int i=((elem.length-1)-1)/2;i>=0;i--){
            AdjustDown(i,elem.length-1);
        }
    }

    @Override
    public void AdjustUp(int child) {
        int parent = (child-1)/2;
        while(child>0){
            if(elem[parent]<elem[child]){
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }

    public boolean isFull() {
        if (this.userSize == elem.length) {
            return true;
        }
        return false;
    }
    @Override
    public void pushHeap(int item) {
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        this.elem[this.userSize] = item;
        this.userSize++;
        AdjustUp(this.userSize-1);
    }

    @Override
    public int popHeap() {
        if(userSize==0){
            throw new UnsupportedOperationException("空堆");
        }
        int tmp = this.elem[0];
        int key  = this.elem[0];
        this.elem[0] = this.elem[this.userSize-1];
        this.elem[this.userSize-1] = tmp;
        this.userSize--;
        AdjustDown(0,this.userSize);
        return key;
    }
    @Override
    public int getHeapTop() {
        return 0;
    }

    @Override
    public void HeapSort() {
        int end = this.userSize-1;
        while(end>0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            AdjustDown(0,end);
            end--;
        }
    }

    @Override
    public void show() {
        for(int i=0;i<this.userSize;i++){
            System.out.print(elem[i]+" ");
        }
    }

}
