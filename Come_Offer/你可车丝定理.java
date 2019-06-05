package com.NewCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day642 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int m = sc.nextInt();
            String ss = GetSequeOddNum(m);
            System.out.println(ss);
        }
    }
    public static String GetSequeOddNum(int m){
        ArrayList arr = new ArrayList();
        int n = (m*m)-(m-1);
       for(int i=0;i<m;i++){
           arr.add(n);
           n+=2;
       }
       StringBuffer sb = new StringBuffer();
     for(int i=0;i<m;i++){
         if(i!=m-1){
             sb.append(arr.get(i)+"+");
         }
     }
     sb.append(arr.get(m-1));
     return sb.toString();
    }
}
