package main.SortPackge.inserSort;

public class selectSort {
    public static void main(String[] args) {
        int[] a = new int[]{32,43,16,13,21,2};
        selectSort(a);
    }

    public static void selectSort(int[] a){
        int tmp = 0;
        int len = a.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(a[j]<a[i]){
                    tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
            System.out.print("第"+(i)+"次：");
            for(int k=0;k<a.length;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
        }

    }
}
