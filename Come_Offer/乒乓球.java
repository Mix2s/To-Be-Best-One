package main.java;

import java.util.Scanner;

public class PingPang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] str = sc.nextLine().split(" ");
            char[] A = str[0].replace(" ","").toCharArray();
            char[] B = str[1].replace(" ","").toCharArray();
            int[] arrA = induce(A);
            int[] arrB = induce(B);
            result(arrA,arrB);
        }
    }
    public static void result(int[] arrA,int[] arrB){
        for(int i=0;i<26;i++){
            if(arrA[i]-arrB[i]>=0){

            }else{
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
    public static int[] induce(char[] ch){
        int[] arr = new int[26];
        for(int i=0;i<ch.length;i++){
            arr[ch[i]-65]++;
        }
        return arr;
    }
}
