import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int k) {
        // write code here
           return quick(a,0,n-1,k);
    }
    public static int quick(int[] array,int left,int right,int k){
        int par = partation(array,left,right);
        if((par-left)>(k-1)&&left<right){
            return quick(array,left,par-1,k);
        }else if((par-left)<(k-1)&&left<right){
                return quick(array,par+1,right,k-par+left-1);
        }else{
            return array[par];
        }
    }
   public static int partation(int[] array,int left,int right){
        int key = array[left];
        while(left<right){
           while(left<right&&array[right]<=key){
               right--;
           }
           array[left]=array[right];
           while(left<right&&array[left]>=key){
               left++;
           }
           array[right]=array[left];
        }
        array[left]=key;
        return left;
   }
}
