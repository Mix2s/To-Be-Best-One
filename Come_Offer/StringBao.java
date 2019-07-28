package Everyday;

public class StringBaohan {
    public static void main(String[] args) {
        System.out.println(numDistinct("a","b"));
    }
    public static int numDistinct(String S, String T) {
            int row = S.length();
            int col = T.length();

            if(row<col){
                return 0;
            }
            int[][] arr = new int[row+1][col+1];

            arr[0][0] = 1;
            for(int i=1;i<=row;i++){
                arr[i][0] = 1;
                for(int j=1;j<=col;i++){
                    if(S.charAt(i-1)==T.charAt(j-1)){
                        arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
                    }else{
                        arr[i][j] = arr[i-1][j];
                    }
                }
            }
            return arr[row][col];
    }
}
