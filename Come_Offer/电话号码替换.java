package main.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class CallNumber {
    public static void main(String[] args) {
        String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number="222333444555666777788899991234567890";
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
               String str = sc.next().replace("-","");
               String ret = "";
               for(int j=0;j<7;j++){
                   ret+=number.charAt(symbol.indexOf(str.charAt(j)));
                }
               ret = ret.substring(0,3)+"-"+ret.substring(3,7);
               if(!list.contains(ret)){
                   list.add(ret);
               }
            }
            Collections.sort(list);
            for(int j=0;j<list.size();j++){
                System.out.println(list.get(j));
            }
            System.out.println();
        }
    }
}
