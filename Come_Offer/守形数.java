package bite.note6;

import java.util.Scanner;

public class shouxingshu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n>=2&&n<9){
                if(((n*n)-n)%10==0){
                    System.out.println("Yes!");
                }else{
                    System.out.println("No!");
                }
            }else{
                if(((n*n)-n)%10==0){
                    System.out.println("Yes!");
                }else{
                    System.out.println("No!");
                }
            }
        }
    }
}
