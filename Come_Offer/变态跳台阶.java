public class Solution {
    public int JumpFloorII(int target) {
        if(target<=0){
            return -1;
        }else if(target==1){
           return 1;
        }else{
            return 2*JumpFloorII(target-1);
        }
    }
}



总结：
得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：

              | 1       ,(n=0 ) 

f(n) =        | 1       ,(n=1 )
              | 2*f(n-1),(n>=2)
//TDDD
