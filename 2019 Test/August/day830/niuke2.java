package main.sort;

import java.util.Scanner;

public class niuke2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(sc.hasNext()){
            String str = sc.nextLine();
            int n = Integer.parseInt(str);
            String str2 = sc.nextLine();
            int[] arr = new int[n];
            String[] ss = str2.split(" ");
            for(int i=0;i<ss.length-1;i++){
                arr[i] = Integer.parseInt(ss[i]);
            }
            String str3 = sc.nextLine();
             sum = 0;
            for(int i=1;i<arr.length;i++){
                sum+=arr[i];
            }
            System.out.println(sum);
        }
    }
}
