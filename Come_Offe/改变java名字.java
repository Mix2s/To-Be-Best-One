package main.java;

import java.util.Scanner;

public class ChangeName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] str = sc.nextLine().split("_");
            StringBuffer sb = new StringBuffer();
            sb.append(str[0]);
            for(int i=1;i<str.length;i++){
                StringBuffer sb1 = new StringBuffer(str[i]).replace(0,1,String.valueOf((char)(str[i].charAt(0)-32)));
                sb.append(sb1);
            }
            System.out.println(sb.toString());
        }
    }
}
