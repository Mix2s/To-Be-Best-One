package test;

import java.util.Scanner;

public class isPa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            if(change(str.substring(0, str.length()-1))
            ||change(str.substring(1,str.length()))
            ||change(str)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static boolean change(String str){
        return new StringBuffer(str).reverse().toString().equals(str);
    }
}
