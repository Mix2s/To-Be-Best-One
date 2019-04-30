package src.com.shuihui.sort;

import java.util.Arrays;

public class mergeSort {
    public static void mergeSort(int[] array,int start,int end){
        if(start>=end){
            return ;
        }
        int mid = (start+end)>>>1;          //找到 中间
        mergeSort(array,start,mid);         //递归排序左边
        mergeSort(array,mid+1,end);
        //合并函数
        merge(array,start,mid,end);
    }
    public static void merge(int[] array,int start,int mid,int end){
        int[] tmpArr = new int[array.length];
        int tmpIndex = start; //存放 tmpArr下标
        int start2 = mid+1;   //第二次归并 start
        int i = start;
        while(start<=mid&&start2<=end) {          //进入 归并过程
            if (array[start] <= array[start2]) {        //如果 array[start] 小于 s2 将两个之中的小值 存入新建数组中
                //新建数组与栈类似 又有 tmpIndex 表示 存放的下标
                tmpArr[tmpIndex++] = array[start++];  //那个值小 存那个
            } else {
                tmpArr[tmpIndex++] = array[start2++];
            }
        }
            while(start<=mid){
                tmpArr[tmpIndex++] = array[start++];
            }
            while(start2<=end){
                tmpArr[tmpIndex++] = array[start2++];
            }
        while(i<=end){
            array[i] = tmpArr[i];
            i++;
        }
        System.out.println(Arrays.toString(array));
    }
}
