package src.day530;

import java.util.Scanner;

/*
    输入一个正数 求n! 的末尾有多少个0
 */
public class que1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(countWays(x,y));
        }
    }

    public static int countWays(int x, int y) {
        if(x==0||y==0){
            return 0;
        }else if(x==1||y==1){
            return 1;
        }else{
            int[][] arr = new int[x][y];
            for(int i=0;i<x;i++){
                arr[i][0]=1;
            }
            for(int i=0;i<y;i++){
                arr[0][i]=1;
            }
            for(int i=1;i<x;i++){
                for(int j=1;j<y;j++){
                    arr[i][j] = arr[i-1][j]+arr[i][j-1];
                }
            }
            return arr[x-1][y-1];
        }
    }
}




public class Robot {
public int countWays(int x, int y) {
if ( x==1 || y==1 )
return 1;
return countWays(x-1,y)+countWays(x,y-1);
}
}
