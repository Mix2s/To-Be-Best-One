package main.SortPackge.inserSort;

public class SheelSort {
    public static void main(String[] args) {
        int[] a = new int[]{32,43,16,13,21,2};
        shellSort(a);
    }
    /**
     * 解决直接插入排序一次直插入一个的问题
     *
     * 分组插入排序
     */
    public static void shellSort(int[] a){
        int len = a.length;
        int count = 0;
        while(len!=0){
            len=len/2;
            for(int i=len;i<a.length;i+=len){
                int tmp = a[i];
                int j = 0;
                for( j=i-len;j>=0;j-=len){
                    if(a[j]>tmp){
                        a[j+len] = a[j];
                    }else{
                        break;
                    }
                }
                a[j+len] = tmp;
            }
            System.out.print("第"+(count++)+"次：");
            for(int k=0;k<a.length;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
        }
    }

    public static void shellSortHand(int[] a){
        int gap[] = {5,3,1};
        for(int n=0;n<gap.length;n++){
            int j = 0;
            int len = a.length;
            int tmp = 0;
            for(int i=gap[n];i<len;i+=gap[n]){
                tmp = a[i];
                for( j=i-gap[n];j>-1;j-=gap[n]){
                    if(a[j]>tmp){
                        a[j+gap[n]] = a[j];
                    }else{
                        break;
                    }
                }
                a[j+gap[n]] = tmp;
            }
            System.out.print("第"+(n+1)+"次：");
            for(int k=0;k<a.length;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
        }
    }
}
