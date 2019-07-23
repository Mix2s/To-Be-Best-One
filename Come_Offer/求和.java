package main.java;

import java.util.ArrayList;
import java.util.Scanner;

public class NeedSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=1;i<=n;i++){
                list.add(i);
                needSum(m,i,i,n,list);
                list.remove(list.size()-1);
            }
        }
    }

    private static void needSum(int m, int sum, int currentVal, int n, ArrayList<Integer> list) {
        if(sum>m){
            return;
        }
        if(sum==m){
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<list.size();i++){
                sb.append(list.get(i)+" ");
            }
            System.out.println(sb.toString().trim());
        }else{
            for(int i=currentVal+1;i<=n;i++){
                list.add(i);
                needSum(m,sum+i,i,n,list);
                list.remove(list.size()-1);
            }
        }
    }
}
