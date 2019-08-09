package main.SortPackge.inserSort;

public class heap2Sort {
    public static void main(String[] args) {
        int[] a = new int[]{32,43,16,13,21,2};
        heapSort(a);
    }
    public static void heapSort(int[] arr){
        int len = arr.length;

        for(int i=len/2-1;i>=0;i--){
            adjust(arr,len,i);
        }
        while(len>1){
            int tmp = arr[len-1];
            arr[len-1] = arr[0];
            arr[0] = tmp;

            len--;
            adjust(arr,len,0);
        }
    }
    private static void adjust(int[] arr,int start,int end){
        int tmp = 0;
        while(end<=start/2-1){
            if(end==start/2-1 && start%2==0){
                tmp = 2*end+1;
            }else{
                int left = 2* end+1;
                int right = left+1;
                tmp = (arr[left]>=arr[right])?left:right;
            }

            if(arr[end]<arr[tmp]){
                int t = arr[end];
                arr[end] = arr[tmp];
                arr[tmp] = t;

                end = tmp;
            }else{
                return;
            }
        }
    }
}
