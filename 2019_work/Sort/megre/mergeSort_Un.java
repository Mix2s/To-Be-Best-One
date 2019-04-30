package src.com.shuihui.sort;

import java.util.Arrays;

/*
    非递归 实现归并排序
    空间复杂度 O（n）
    时间复杂度 N*log2(N)
    稳定
 */
public class mergeSort_Un {
    public static void mergeSort_Un(int[] array){
        for(int i=1;i<=array.length;i=2*i){
            merge(array,i);
        }
    }
    public static void merge(int[] array,int gap){
        int[] tmpArray = new int[array.length];
        int i=0;  //tmpArray 的下标
        int start1 = 0;
        int end1 = start1+gap-1;
        int start2 = end1+1;
        int end2 = start2+gap-1>array.length-1?
                array.length-1:start2+gap-1;
        //保证有两个段
        while(start2<array.length){
            //两个归并段 在归并中 都要有数据
            while(start1<=end1&&start2<=end2){
                if(array[start1]<=array[start2]){
                    tmpArray[i++] = array[start1++];
                }else{
                    tmpArray[i++] = array[start2++];
                }
            }
            while(start1<=end1){
                tmpArray[i++] = array[start1++];
            }
            while(start2<=end2){
                tmpArray[i++] = array[start2++];
            }
            start1 = end2+1;
            end1 = start1+gap-1;
            start2 = end1+1;
            end2 = start2+gap-1>array.length-1?array.length-1:start2+gap-1;
            System.out.println(Arrays.toString(array));
        }
        while(start1<=array.length-1){       //start1<=end1 加入最后一个数组 只有一个值 就会发生数组越界
            tmpArray[i++] = array[start1++];
        }
        for (int j = 0; j < tmpArray.length; j++) {
            array[j] = tmpArray[j];
        }
    }
}
