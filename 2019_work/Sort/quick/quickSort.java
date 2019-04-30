package src.com.shuihui.sort;
/*
    时间复杂度O(n)=n*log2(n)
    空间复杂度 log2(n) 浪费在 par
    不稳定
 */
public class quickSort {
    public static void quickSort(int[] array){
           int key = array.length-1;
           quick(array,0,key);
    }
    public static void quick(int[] array,int low,int high){
        if(low==high) {
            return;
        }
        if(high-low+1 <= 10){
           insertSort(array,low,high);
        }
        takeThreadNumber(array,low,high);
        int par = partion(array, low, high);
        //递归左边
        if(par>low+1){
            quick(array,low,par-1);
        }
        //递归右边
        if(par<high-1){
            quick(array,par+1,high);
        }
    }
    public static void insertSort(int[] array,int low,int high) {
        for (int i = low + 1; i <= high; i++) {
            int tmp = array[i];
            int j=0;
            for (j = i - 1; j >= low; j--) {
                if (tmp < array[i]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }
    public static void takeThreadNumber(int[] array,int low,int high){
        int mid = (low+high)>>>1;
        if(array[mid]>array[low]){
            swap(array,low,mid);
        }
        if(array[mid]>array[high]){
            swap(array,mid,high);
        }
        if(array[low]>array[high]){
            swap(array,low,high);
        }
    }
    public static void swap(int[] array,int low,int high){
        int tmp = array[low];
        array[low]=array[high];
        array[high]=tmp;
    }
    public static int partion(int[] array,int low,int high){
        int tmp = array[low];
        while(low<high){
            while((low<high)&&array[high]>=tmp) {      //进入的条件当前面的值比目标小
                high--;
            }
            if(low==high){
                break;
            }else{
                array[low]=array[high];
            }

            while((low<high)&&array[low]<=tmp){            //进入条件找目标值大
                low++;
            }
            if(low==high){
                break;
            }else{
                array[high]=array[low];
            }
        }
        array[low]=tmp;
        return low;
    }
}
