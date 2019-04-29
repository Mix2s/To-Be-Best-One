package src.com.shuihui.sort;
/*
    时间复杂度 O（n²）
    稳定排序
    越接近有序时间越快
    如果给定的时有序
    时间复杂度O(n)
 */
public class insertSort {
    /*
        1.i从数组开始的第二个位置开始
        2.j从第一个开始
        3.将i的数值拿出来存放到 tmp中
        4.子循环j比较 j与i的值大小 ｛如果j大则交换位置  因为i始终比j大一｝
        5.将J 倒序向前 如果前面的值小于 则不变位置 如果大于则改变

     */
    public static void insertSort(int[] array){
        int tmp=0;
        int j = 0;
        for(int i = 1;i<array.length;i++){
           tmp = array[i];
           for(j=i-1;j>-1;j--){
               if(array[j]>tmp){
                   array[j+1]=array[j];  //将当前元素前一个元素 移到当前位置
               }else{
                   break;
               }
           }
           array[j+1]=tmp;
        }
    }
}
