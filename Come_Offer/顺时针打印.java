package src.javaTest;

import java.util.ArrayList;
import java.util.List;

public class day513 {
    List a = new ArrayList();
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        day513 dd = new day513();
        dd.print(array);
    }

    public  ArrayList print(int[][] array) {
        int tr = 0;
        int tc = 0;   //tr tc 左上角初始值
        int dr = array.length - 1;
        int dc = array[0].length - 1;     //dr dc 右下角初始值
        while (tr <= dr && tc <= dc) {  //左上角等于右下角时结束
            printEdge(array, tr++, tc++, dr--, dc--);
        }
        return a;
    }

    public void printEdge(int[][] a,int tr,int tc,int dr,int dc){
        if(tr==dr){  //当只有一行时候 把这一行打印出来
            for(int i = tc;i<=dc;i++){
                a.add(a[tr][i]);
            }
        }
        if(tc==dc){ //当只有一列时候
            for(int i=tr;i<=dr;i++){
                a.add(a[i][tc]);
            }
        }
        int curc = tc;
        int curr = tr; //两个当前变量 存储当前位置
        while(curc!=dc){
            a.add(a[tr][curc]);
            curc++;
        }
        while(curr!=dr){
            a.add(a[curr][tc]);
            curr++;
        }
        while(curc!=tc){
            a.add(a[dr][curc]);
            curc--;
        }
        while(curr!=tr){
            a.add(a[curr][tc]);
            curr--;
        }
    }
    public static ArrayList<Integer> printMatrix(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (array.length == 0) return result;
        int n = array.length, m = array[0].length;
        if (m == 0) return result;
        int layers = (Math.min(n, m) - 1) / 2 + 1;//这个是层数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) result.add(array[i][k]);//左至右
            for (int j = i + 1; j < n - i; j++) result.add(array[j][m - i - 1]);//右上至右下
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) result.add(array[n - i - 1][k]);//右至左
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) result.add(array[j][i]);//左下至左上
        }
        return result;
    }
}
