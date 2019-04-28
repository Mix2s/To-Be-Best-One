package src.com.shuihui.sort;
/*
    时间复杂度O(n)=n*log2(n)
    空间复杂度 log2(n) 浪费在 par
    不稳定
 */
public class quickSort {
    public static void takeThreadNumber(int[] array,int low,int high){
        int tmp=0;
        int mid = (low+high)>>>1;
       if(array[mid]>array[low]){

       }
       if(array[mid]>array[high]){

       }
       if(array[low]>array[high]){

       }
    }
    public static void quickSort(int[] array){
           int key = array.length-1;
           quick(array,0,key);
    }
    public static void quick(int[] array,int low,int high){
        if(low==high) {
            return;
        }
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
    public static int partion(int[] array,int low,int high){
        int tmp = array[0];
        while(low<high){
            while((low<high)&&array[high]>tmp) {      //进入的条件当前面的值比目标小
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
