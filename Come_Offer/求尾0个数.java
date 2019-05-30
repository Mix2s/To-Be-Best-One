package src.day530;

import java.util.Scanner;

/*
    输入一个正数 求n! 的末尾有多少个0
 */
public class que1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count =0 ;
       for(int i=n;i>=5;i--){
            int tmp = i;
            while(tmp%5==0){
                count++;
                tmp/=5;
            }
       }
        System.out.println(count);
    }
}
