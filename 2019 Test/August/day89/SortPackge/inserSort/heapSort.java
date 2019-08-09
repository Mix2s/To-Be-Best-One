package main.SortPackge.inserSort;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class heapSort {
    public static void main(String[] args) {
        int[] a = new int[]{32,43,16,13,21,2};
        heapSort(a);
    }

    public static void heapSort(int[] array){
       for(int root = array.length/2-1;root>=0;root--){
           adjust(array, array.length,root);
       }

       int count  = array.length;
       int k = 0;
       while(count>1){
           int tmp = array[count-1];
           array[count-1] = array[0];
           array[0] = tmp;

           count--;
           adjust(array,count,0);
           System.out.print("第"+k+++"次：");
           for(int i=0;i<array.length;i++){
               System.out.print(array[i]+" ");
           }
           System.out.println();
       }
    }
    public static void adjust(int[] array,int count,int root){
        int maxChilndex;
        while(root<=count/2-1){   //count/2-1拿到上一层的左子叶节点
            if(root == count/2-1 && count%2==0){
                //当叶节点为欧舒适 最有一个非叶子节点只有一个左孩子
                maxChilndex = 2*root+1;
            }else{
                int left = 2*root+1;
                int right = left+1;
                if(array[left]>=array[right]){
                    maxChilndex = left;
                }else{
                    maxChilndex = right;
                }
            }

            if(array[root]<array[maxChilndex]){
                int tmp = array[root];
                array[root] = array[maxChilndex];
                array[maxChilndex] = tmp;

                root = maxChilndex;
            }else{
                return;
            }
        }
    }
}
