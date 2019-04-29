package src.com.shuihui.sort;
/*
        选择排序
       时间复杂度 O（n²）
       空间复杂度 O（1）
 */
public class selectSort {
    public static void selectSort(int[] array){
        int tmp = 0;
        int key =array.length;
        for(int i=0;i<key;i++){
            for(int j=i+1;j<key;j++){
                if(array[i]>array[j]){  //如果前面的大于后面的
                    tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
}
