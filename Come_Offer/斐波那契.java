public class Solution {
    public int Fibonacci(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        if(n==0){
            return 0;
        }
        if(0<n&&n<=2){
            return 1;
        }
        while(n>2){
        f3=f1+f2;
        f1=f2;
        f2=f3;
         n--;
        }
        return f3;
    }
}
本解思路：(不递归)
    写出满足的所有条件，当等于n=0时，当n<=2时，当n>2时不停地变换f1，f2的值 1 1| 2 3 5。。。
    
    
    
    public class Solution {
    public int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
      if(n>0&&n<=2){
          return 1;
      }else{
          return Fibonacci(n-1)+Fibonacci(n-2);
      }
    }
｝
本届思路：使用递归的思维，求n就要知道n-1+n-1；以此类推
