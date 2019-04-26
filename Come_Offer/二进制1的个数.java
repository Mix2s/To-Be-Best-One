public class Solution {
    public int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }
}
/*
方案一
     int t = 1;
       int count = 0;
        while(t!=0){
            if((n&t)!=0){
                count++;
            }
            t=t<<1;
        }
        return count;
    }
*/

总结：
    方案一
    使用 1 不断地左移 让和每一位都进行& 运算 1101 和 0001   +1
                                        1101    0010    
                                        1101    0100  +1
                                        1101    1000  +1
    方案二
                                        1100 & 1011  1000  +1
                                        1000 & 0111  0000  +1
    
