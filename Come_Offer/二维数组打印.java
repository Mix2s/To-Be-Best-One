package test;

public class arrSort {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        arrayPrint(arr, 4);
    }

    public static int[] arrayPrint(int[][] arr, int n) {
        int[] aa = new int[arr.length*(arr[0].length)];
        int count = 0;
        for(int i=0;i<arr.length+arr[0].length-1;i++){
            for(int j=0;j<arr.length;j++){
                int x = j+arr[0].length-i-1;
                if(0<=x&&x<=arr[0].length-1){
                    aa[count++] = arr[j][x];
                }
            }
        }
        return aa;

    }
}
