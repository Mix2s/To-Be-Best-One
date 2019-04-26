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

              | -1       ,(n=0 )            //没有台阶怎么跳

f(n) =        | 1       ,(n=1 )
              | 2*f(n-1),(n>=2)
//TDDD
n=1 f(1)=f(1)
n=2 f(2)=f(2-1)+f(2-2)
    n=3 f(3)=f(3-1)+f(3-2)+f(3-3)
    .....
    n=n-1 f(n-1)=(n-2)+f(n-3).....f(n-1-(n-1))
    n=n    f(n)=f(n-1)+f(n-2).....f(n-n)
            f(n)=2*f(n-1)
    这是一个推理过程  将他的每一种使用函数的方式表示
    退出 递归的 整个函数表达式
