package Everyday;

import java.util.Scanner;

/**
 * 合唱团
 */
public class SingAndSum {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while(sc.hasNext()){
           int n = sc.nextInt();
           int[] arr = new int[n+1];
           for(int i=1;i<=n;i++){
               arr[i] = sc.nextInt();
           }
           int kk = sc.nextInt();
           int d = sc.nextInt();

           long[][] fmax = new long[kk+1][n+1];
           long[][] fmin = new long[kk+1][n+1];

           long res = Integer.MIN_VALUE;
           for(int i=1;i<=n;i++){
               fmax[1][i] = arr[i];
               fmin[1][i] = arr[i];
               for(int k=2;k<=kk;k++){
                   for(int j=i-1;j>0&&i-j<=d;j--){
                       fmax[k][i] = Math.max(fmax[k][i], Math.max(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                       fmin[k][i] = Math.min(fmin[k][i], Math.min(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                   }
               }
               res = Math.max(res,fmax[kk][i]);
           }
           System.out.println(res);
        }
    }
}
