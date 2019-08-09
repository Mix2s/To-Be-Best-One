package main.SortPackge.inserSort.quickSort;

public class quickSort {
    public static void main(String[] args) {
        int[] a = new int[]{44,43,16,13,21,2};
        quickSort(a);
        for(int i=0;i<a.length;i++){
           System.out.print(a[i]+" ");
       }
    }
    public static void quickSort(int[] a){
        quick(a,0,a.length-1);
    }

    private static void quick(int[] a, int start, int end) {
          if(start==end){
              return ;
          }
          takeThreeNumber(a,start,end);
         int par = partion(a,start,end);
        if(par>start+1){
            quick(a,start,par);
        }
        if(par<end-1){
            quick(a,par+1,end);
        }
    }



    private static void takeThreeNumber(int[] array, int low, int high) {
        int mid = (low+high)>>>1;
        if(array[mid]>array[low]){
            int tmp = array[low];
            array[low]=array[high];
            array[high]=tmp;
        }
        if(array[mid]>array[high]){
            int tmp = array[low];
            array[low]=array[high];
            array[high]=tmp;
        }
        if(array[low]>array[high]){
            int tmp = array[low];
            array[low]=array[high];
            array[high]=tmp;
        }
    }

    private static int partion(int[] a, int start, int end) {
        int tmp = a[start];
        while(start<end){
            while((start<end) && a[end]>=tmp){
                end--;
            }
            if(start==end){
                break;
            }else{
                a[start] = a[end];   //高位找到低于a[start]的值 将高位赋值给地位
            }

            while((start<end) && a[start]<=tmp){
                start++;
            }
            if(start==end){
                break;
            }else{
                a[end] = a[start];
            }
        }
        a[start] = tmp;
        return start;
    }
}
