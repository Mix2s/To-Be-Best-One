package main.sort;

import java.util.Arrays;

public class sorts {
    public static void main(String[] args) {
        int[] arr = new int[]{3,9,-1,10,20};
        insertSort(arr);
       // selectSrot(arr);
        //bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        int temp = 0;
        int j = 0;
        for(int i=1;i<arr.length;i++){
            temp = arr[i];
            for(j=i-1;j>=0;j--){
                if(arr[j]>temp){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }
    public static void selectSrot(int[] arr){
        /**
         * 选择排序
         */
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j = i;j<arr.length;j++){
                if(arr[j]<arr[i]){
                   min = j;  //保存最小值的下标用于交换
                }
                int temp= arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
    public static void bubbleSort(int[] arr){
        /**
         * 冒泡排序
         * 时间复杂度 O（n^2）
         */
        int temp = 0;
        boolean flag = false;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                    if(arr[j]>arr[j+1]){
                        flag = true;
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }
}
