package main.SortPackge.inserSort;

public class bubbleSort {
    static boolean flag;
    public static void main(String[] args) {
        int[] a = new int[]{32,43,16,13,21,2};
        bubbleSort(a);
    }
    public static void bubbleSort(int[] a){
        flag = false;
        int len = a.length;
        for(int i=0;i<len;i++){
            flag = false;
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
            System.out.print("第"+i+"次：");
           for(int k=0;k<a.length;k++){
               System.out.print(a[k]+" ");
           }
            System.out.println();
        }
    }
}
