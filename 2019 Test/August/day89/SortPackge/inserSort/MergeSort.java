package main.SortPackge.inserSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{32,43,16,13,21,2};
        mergeSort(a,0,a.length-1);
    }
    public static void mergeSort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)>>>1;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] tmpArr = new int[array.length];
        int tmpIndex = start;
        int start2 = mid+1;
        int i =start;
        while(start<=mid && start2<=end) {
            if (array[start] <= array[start2]) {
                tmpArr[tmpIndex++] = array[start++];
            } else {
                tmpArr[tmpIndex++] = array[start2++];
            }
        }
            while(start<=mid){
                tmpArr[tmpIndex++] = array[start++];
            }
            while(start2<=end){
                tmpArr[tmpIndex++]  = array[start2++];
            }

            //重新写回 array
            while(i<=end){
                array[i] = tmpArr[i];
                i++;
            }
        System.out.println(Arrays.toString(array));
    }
}
