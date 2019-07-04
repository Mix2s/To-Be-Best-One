package bite.note4;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int cur = n*n;
            int count = 0;
            int jisu = 0;
            int pingfa = 0;
            while(n>0){
               jisu = n%10;
               n=n/10;
               count+=jisu;
            }
            while((cur)>0){
                jisu = cur%10;
                cur =cur/10;
                pingfa+=jisu;
            }
            System.out.println(count+" "+pingfa);
        }
    }
}
