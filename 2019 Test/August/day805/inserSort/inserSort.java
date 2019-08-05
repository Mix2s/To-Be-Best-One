package main.SortPackge.inserSort;

public class inserSort{
    public static void main(String[] args) {
        int[] a = new int[]{32,43,16,13,21,2};
        inserSort(a);
    }
    public static void inserSort(int[] a){
        int j = 0;
        int len = a.length;
        int tmp = 0;
        for(int i=1;i<len;i++){
            tmp = a[i];
            for( j=i-1;j>-1;j--){
                if(a[j]>tmp){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = tmp;
            System.out.print("第"+i+"次：");
            for(int k=0;k<a.length;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
        }
    }
}
