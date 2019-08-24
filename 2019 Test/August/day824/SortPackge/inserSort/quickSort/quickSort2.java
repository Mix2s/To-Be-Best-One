package main.SortPackge.inserSort.quickSort;

public class quickSort2 {
    public static void main(String[] args) {
        int[] a = new int[]{32,43,16,13,21,2};
        quickSort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void quickSort(int[] a){
        quick(a,0,a.length-1);
    }
    public static void quick(int[] a,int left,int right){
        if(left>=right){
            return;
        }
        int beleft  = left;
        int beright = right;
        int key = a[left];
        while(left<right){
            while(left<right&&a[right]>=key){
                right--;
            }
            if(left<right){
                a[left] = a[right];
                left++;
            }

            while(left<right&&a[left]<key){
                left++;
            }
            if(left<right){
                a[right] = a[left];
                right--;
            }
        }

        a[left] = key;
        quick(a,beleft,left-1);
        quick(a,right+1,beright);
    }

}
