package Everyday;

public class StringShendu {
    public static void main(String[] args) {
        int[] boks = {1,2,3};
        int[] book = {0,0,0};
        DFS(0,3,boks,book);
    }
    public static void DFS(int index,int n,int[] boks,int[] book){
       if(index ==n){
           for(int i=0;i<n;i++){
               System.out.print(boks[i]+" ");
           }
           System.out.println();
           return;
       }
        for(int i=1;i<=n;i++) {
            if (book[i-1] == 0) {
                boks[index] = i;
                book[i-1] = 1;
                DFS(index + 1, n, boks, book);
                book[i-1] = 0;
            }
        }
    }
}
