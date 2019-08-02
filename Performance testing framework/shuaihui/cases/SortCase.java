package com.shuaihui.cases;

;

import com.shuaihui.Case;
import com.shuaihui.annotations.BenchMark;
import com.shuaihui.annotations.Measurement;

import java.util.Arrays;
import java.util.Random;

/**
 * 测试快排 归并
 */
@Measurement(iterations = 10,group = 3)
public class SortCase implements Case {
    public void quickSort(int[] a) {
        //确定脊椎之
        quickSortInternal(a, 0, a.length - 1);
    }

    public void quickSortInternal(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int[] parIndex = partion(a, low, high);
        //low---par-1  par+1----high

        quickSortInternal(a, low, parIndex[0]);
        quickSortInternal(a,  parIndex[1], high);

    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private int[] partion(int[] a, int low, int high) {
        int par = a[high];
        int less = low;
        int i = low;
        int more = high;

        while (i < more) {
            if (a[i] == par) {
                i++;
            } else if (a[i] < par) {
                swap(a, i, less);
                i++;
                less++;
            } else {
                while (a[more] > par && more > i) {
                    more--;
                }
                swap(a, i, more);
            }
        }
        return new int[]{less-1,more};
    }



    public void mergeSort(int[] a){
        mergeSortInternal(a,0,a.length);
    }

    private void mergeSortInternal(int[] a, int low, int high) {
        if(high<=low+1){
            return;
        }
        int mid  = (low+high)>>1;

        mergeSortInternal(a,low,mid);
        mergeSortInternal(a,mid,high);

        merge(a,low,mid,high);
    }

    private void merge(int[] a, int low, int mid, int high) {
        int len = high-low;
        int[] tmp =  new int[len];
        int i = low;
        int j = mid;
        int k = 0;
        while(i<mid&&j<high){
            if(a[i]<=a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        while(i<mid){
            tmp[k++]= a[i++];
        }

        while(j<high){
            tmp[k++] = a[j++];
        }

        System.arraycopy(tmp,0,a,low,len);
    }

   @BenchMark
    public void testQuickSort(){
        int[] a = new int[100000];
       Random random = new Random(20190801);
       for(int i=0;i<a.length;i++){
           a[i] = random.nextInt(100000);
       }
       quickSort(a);
   }


    @BenchMark
    public void testMergeSort(){
        int[] a = new int[100000];
        Random random = new Random(20190801);
        for(int i=0;i<a.length;i++){
            a[i] = random.nextInt(100000);
        }
        quickSort(a);
    }

    @BenchMark
    public void testArraySort(){
        int[] a = new int[100000];
        Random random = new Random(20190801);
        for(int i=0;i<a.length;i++){
            a[i] = random.nextInt(100000);
        }
        Arrays.sort(a);
    }

    @BenchMark
    public void testArraysMergeSort(){
        int[] a = new int[100000];
        Random random = new Random(20190801);
        for(int i=0;i<a.length;i++){
            a[i] = random.nextInt(100000);
        }
        Arrays.sort(a);
    }
}
