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
方案三
public int minNumberInRotateArray(int [] array) {
           int left = 0;
           int right = array.length-1;
            if(right==-1){
                return 0;
            }
           int mid = 0;
           while(array[left]>=array[right]){
               if(right-left==1){
                   mid = right;
                   break;
               }
               mid = left+(right-left)/2;
               if(array[mid]>=array[left]){
                      left = mid;
               }
               if(array[mid]<=array[right]){
                       right = mid;
               }
           }
           return array[mid];
    }
总结
  1.采用二分查找的思维去解决
  2。如果左边的数字大于或等于右边的数字 那么就是循环结束 
	3。当中间值 大于等于左边 则证明左半 数字都没有最小值
	4.如果中间小于等于右边证明 最小数在最右边
	5 当循环到只有两个值时 一开始是偶数 在执行倒数第二次循环时 array[mid]<=array[ritght] ritgh=mid;此时 right指向最小值

