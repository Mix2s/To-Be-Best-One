public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0){
            return 0;
            }
        int sum = array[0];
        int tmp = sum;
        for(int i=1;i<array.length;i++){
            //sum = (sum>0)?sum+array[i]:array[i];
            //tmp = (sum<tmp)?tmp:sum;
            
            if(sum>0){
                sum +=array[i];
            }else{
                sum = array[i];
            }
            if(sum>tmp){
                tmp = sum;
            }
        }
        return tmp;
    }
}
