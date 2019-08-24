package main;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class hechang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(in.next());
            }
            int count = 1;
            int tmp = 0;
            for(int i=0;i<n-1;i++){
                tmp = arr[i];
                if(arr[i+1]>tmp){
                    count++;
                    tmp = arr[i+1];
                }else{
                    continue;
                }
            }
            System.out.println(count);
        }
    }
}
