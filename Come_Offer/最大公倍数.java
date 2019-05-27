import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(gongbei(x,y));
    }
    public static int gongbei(int x,int y){
       int tmp=0;
       if(x>=y){
           tmp=x;
       }else{
           tmp=y;
       }
      for(int i=tmp;tmp<=x*y;tmp++){
          if((tmp%x==0)&&(tmp%y==0)){
              return tmp;
          }
      }
        return 0;
    }
}
