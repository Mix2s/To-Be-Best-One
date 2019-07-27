package Everyday;

public class printArr {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int startX = 0;
        int endX = m-1;
        int startY = 0;
        int endY = n-1;
        int index = 0;
        int[] result = new int[n*m];

        while(startX<=endX && startY <=endY){
            if(startX<=endX){
                for(int i=startX;i<endX;i++){
                    result[index++] = mat[startY][i];
                }
            }
            if(startY< endY){
                for(int i=startY+1;i<=endY;i++){
                    result[index++] = mat[i][endX];
                }
            }
            if(startX<endX&&endY>startY){
                for(int i=endX-1;i>=startX;i--){
                    result[index++] = mat[endY][i];
                }
            }
            if(startY<endY&&endX>startX){
                for(int i=endY-1;i>=startY+1;i--){
                    result[index++] = mat[i][startX];
                }
            }
            startX++;
            endX--;
            startY++;
            endY--;
        }
        return result;
    }
}
