

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while(sc.hasNext()){
           int count = 0;
           int n = sc.nextInt();
           if(n==0){
               break;
           }
           int[] arr = new int[n];
           for(int i=0;i<n;i++){
               arr[i] = sc.nextInt();
           }
           int gade = sc.nextInt();
           for(int i=0;i<n;i++){
               if(arr[i]==gade){
                   count++;
               }
           }
           System.out.println(count);
       }

    }

}

//        3
//        80 60 90
//        60
//        2
//        85 66
//        0
//        5
//        60 75 90 55 75
//        75
//        0
