package daydayup;

import java.util.Scanner;

public class day6121 {
    public static void main(String[] args) {
        System.out.println(10%10);
        Scanner sc = new Scanner(System.in);
        int monthCount = sc.nextInt();
        System.out.println(getTotalCount(monthCount));
    }
    public static int getTotalCount(int monthCount){
          int f1 = 1;
          int f2 = 1;
          int f3 = 0;
          if(monthCount<=2){
              return 1;
          }
          for(int i=0;i<monthCount-2;i++){
                f3 = f1+f2;
                f1 = f2;
                f2 = f3;
          }
          return f3;
    }
}
