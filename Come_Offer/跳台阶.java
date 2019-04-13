public class Solution {
    public int JumpFloor(int target) {
        //斐波那契问题
       if(target>2){
           return JumpFloor(target-1)+JumpFloor(target-2);
       }else if(target==2){
           return 2;
       }else if(target<2){
           return 1;
       }else{
           return 0;
       }
       }
    }
    本解思路：完全将跳台阶问题转化为解决类似斐波那契问题，方便起见写为递归，减少消耗的情况下可以写为交换
    
    public class Solution {
    public int JumpFloor(int target) {
        int f1=1;
        int f2=2;
        int f3=0;
        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        while(target>2){
            f3=f1+f2;
            f1=f2;
            f2=f3;
            target--;
        }
        return f3;
    }
}
思路：斐波那契的交换
