

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sort_class(arr);
    }

    private static void sort_class(int[] arr) {
        int a1 = 0;
        int a1count = 0;
        int a2 = 0;
        int a2count = 0;
        int a3 = 0;
        int a3count = 0;
        int a4 = 0;
        int a4count = 0;
        int a5 = 0;
        int a5count = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int j = 0;
           if(arr[i]%5==0&&arr[i]%2==0){
               a1count++;
              a1+=arr[i];
           }
           if(arr[i]%5==1){
               a2+=(Math.pow(-1,a2count))*arr[i];
               a2count++;
           }
           if(arr[i]%5==2){
               a3count++;
               a3++;
           }
           if(arr[i]%5==3){
               a4count++;
               a4+=arr[i];
               count++;
           }
           if(arr[i]%5==4){
               a5count++;
               if(arr[i]>a5){
                   a5 = arr[i];
               }
           }
        }
        String aa = new DecimalFormat("0.0").format(a4*1.0/count);
        StringBuffer sb = new StringBuffer();
        if(a1count!=0){
            sb.append(a1);
        }else{
            sb.append("N");
        }
        sb.append(" ");

        if(a2count!=0){
            sb.append(a2);
        }else{
            sb.append("N");
        }
        sb.append(" ");

        if(a3count!=0){
            sb.append(a3);
        }else{
            sb.append("N");
        }
        sb.append(" ");

        if(a4count!=0){
            sb.append(aa);
        }else{
            sb.append("N");
        }
        sb.append(" ");

        if(a5count!=0){
            sb.append(a5);
        }else{
            sb.append("N");
        }
        System.out.println(sb);
    }
}
//13 1 2 3 4 5 6 7 8 9 10 20 16 18
