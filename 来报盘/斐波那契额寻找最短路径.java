package src.day530;

import java.util.Scanner;

public class day5302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        while(f3<=N){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        if((f2-N)>(N-f1)){
            System.out.println(N-f1);
        }else{
            System.out.println(f2-N);
        }
    }
}
