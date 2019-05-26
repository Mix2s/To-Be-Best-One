package src.javadyday;

import java.util.Scanner;

public class day5261 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a_b = sc.nextInt();
        int b_c = sc.nextInt();
        int ab = sc.nextInt();
        int bc = sc.nextInt();
        test(a_b,b_c,ab,bc);
    }
    public static void test(int a_b,int b_c,int ab,int bc){
        boolean tmp = false;
            for(int a=-30;a<=30;a++){
                for(int b=-30;b<=30;b++){
                    for(int c=-30;c<=30;c++){
                        if((a_b==a-b)&&(b_c==b-c)&&(ab==a+b)&&(bc==b+c)){
                            tmp = true;
                            System.out.println(a+" "+b+" "+c);
                        }
                    }
                }
            }
            if(tmp==false){
                System.out.println("No");
            }
        }
}
