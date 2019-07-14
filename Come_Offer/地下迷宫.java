package bite.note6;

import java.util.Scanner;

public class GuaGuaLive {
    static String path = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int power = sc.nextInt();
            int[][] map = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    map[i][j] = sc.nextInt();
                }
                System.out.println(pathPut(n,m,map,power));
            }
        }
    }

    private static String pathPut(int n, int m, int[][] map, int power) {
        if(n<=0){
            return "Can not escapel";
        }
        boolean[][] visited  = new boolean[n][m];
        findPath(n,m,map,0,0,"",visited,power);
        return path;
    }

    private static void findPath(int n, int m, int[][] map, int nowx, int nowy, String s, boolean[][] visited, int power) {
        if(nowx==0&&nowy==m-1&&map[0][m-1]==1){
            if(power>=0){
                path = s+"[0,"+(m-1)+"]";
            }else{
                path = "Can not escapel";
            }
            return ;
        }
        if(nowx<n&&nowy<m&&nowx>=0&&nowy>=0&&map[nowx][nowy]==1&&!visited[nowx][nowy]){
            visited[nowx][nowy] = true;
            s+="["+nowx+","+nowy+"],";


            findPath(n, m, map, nowx, nowy + 1, s, visited, power - 1);
            // 向下
            findPath(n, m, map, nowx + 1, nowy, s, visited, power);
            // 水平向左
            findPath(n, m, map, nowx, nowy - 1, s, visited, power - 1);
            // 向上
            findPath(n, m, map, nowx - 1, nowy, s, visited, power - 3);
        }
    }
}
