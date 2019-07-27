package Everyday;

public class leftAndrigth {
    public static void main(String[] args) {
        int[] arr = {28,75,38,44,66,1};
        int[] arr2 = {95,73,15,94,78};
        System.out.println(findMaxGap(arr2,5));
    }
    public static int findMaxGap(int[] A, int n) {
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = A[i];
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                dp[i][j] = Math.max(dp[i][j-1],A[j]);
            }
        }
        int max = 0;
        for(int k=0;k<n-1;k++){
            if(Math.abs(dp[0][k]-dp[k+1][n-1])>max){
                max = Math.abs(dp[0][k]-dp[k+1][n-1]);
            }
        }
        return max;
  /*      int max = 0;
        for(int i=0;i<n;i++){
            if(A[i]>max){
                max = A[i];
            }
        }
        return max - (A[0]>A[n-1]?A[n-1]:A[0]);*/
    }
}
