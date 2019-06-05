package com.NewCode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class day641 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
           String str = sc.nextLine();
            out(str);
        }
    }
    public static void out(String arr) {
        String[] str = arr.split(" ");
        int[] sq = new int[10];
        for (int i = 0; i < 10; i++) {
            sq[i] = Integer.parseInt(new StringBuffer().append(str[i]).toString());
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<10;i++){
            if(sq[i]!=0){
                sb.append(i);
                sq[i]--;
                break;
            }
        }
        for(int i=0;i<10;i++){
            if(sq[i]!=0){
                while(sq[i]!=0){
                    sb.append(i);
                    sq[i]--;
                }
            }
        }
        System.out.println(sb);
    }
}
