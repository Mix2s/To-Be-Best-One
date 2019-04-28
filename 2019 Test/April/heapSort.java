package src.com.shuihui.sort;
/*
        2Nlog2(n)
        空间 O（1）

        topk 问题
 */
public class heapSort {
    public static void heapSort(int[] array){
        int key=array.length;
        for(int i = (key-1-1)/2;i>=0;i--){
            adjust(array,i,key-1);
        }//整棵树变为 大根堆  时间复杂度 Nlog2(n)

        //调换 最后的位置
        for (int i = 0; i <=key ; i++) {
            int tmp = array[0];
            array[0]=array[array.length-1-i];
            array[array.length-1-i] = tmp;
            adjust(array,0,array.length-1-i);  //先交换 在调整 所以 -1 不用调换最后一个树
        }
    }
    public static void adjust(int[] array,int start,int end){
       int tmp = array[start];
       for(int i=2*start-1;i<=end;i=2*i+1){
           if((i<end)&&(array[i]<array[i+1])){    //比较两个兄弟节点 大小 拿到最大的角标
               i++;  //i++保存最大值下标
           }
           if(array[i]>tmp){
               array[start] = array[i];
               start=i;
           }else if(array[i]<tmp){
              // array[start]=tmp;  break之后 有 重复执行所以去掉
               break;
           }
       }
       array[start]=tmp;  //走完 for 有一个交换完的 位置是空的 用tmp填
    }
}

