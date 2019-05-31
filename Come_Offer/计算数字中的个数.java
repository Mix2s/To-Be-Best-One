package src.day513;

import java.util.Scanner;

public class question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[10];
        String str = in.next();;
        for (int i = 0; i < str.length(); i++) {
            a[str.charAt(i)-'0']++;
        }
        for(int i=0;i<str.length();i++){
            if(a[i]!=0){
                System.out.println(i+":"+a[i]);
            }
        }
        //        Scanner in = new Scanner(System.in);
//        int[] a = new int[10];
//        String n = in.next();
//        for(int i = 0;i<n.length();i++) {
//            a[n.charAt(i) - '0']++;
//        }
//        for(int i = 0;i<a.length;i++){
//            if(a[i]!=0)
//                System.out.println(i+":"+a[i]);
//        }
    }
}
