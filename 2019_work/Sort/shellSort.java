package src.com.shuihui.sort;
/*
    优化版 插入排序
 */
public class shellSort {
    public static void shellSort(int[] array){
        int[] div = {5,3,1};
        for (int i = 0; i <div.length ; i++) {
            shell(array,div[i]);
        }
    }
    /*
        1.通过改变 i的初始值 完成第一阶段的分组 不是意义上的分组 i++
        2.
     */
    public static void shell(int[] array,int gap){
        int tmp=0;
        for(int i = gap;i<array.length;i++){
             tmp = array[i];
            int j = 0;
            for(j=i-gap;j>=0;j=j-gap){
                if(array[j]>tmp){               //比较当前j的值 和tmp的大小
                    array[j+gap]=array[j];          //将当前分组元素的前一个元素 移到当前位置
                }else{
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
}
