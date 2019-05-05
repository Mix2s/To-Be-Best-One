方案一
  遍历整个数组 寻找最小值 
方案二
  向后遍历找到第一次小于的值
public class Solution {
    public int minNumberInRotateArray(int [] array) {
           for(int i = 0;i<array.length;i++){
               for(int j = 1;j<array.length;j++){
                   if(array[j]<array[i]){
                          return array[j];
                   }
               }
           }
        return 0;
    }
}
总结 
    1.只要向后遍历找到第一次小于前面的值 自然就是最小值
