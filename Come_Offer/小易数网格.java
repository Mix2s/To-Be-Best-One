import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        System.out.println(Ojld(w,h));
    }
    public static int Ojld(int w,int h){
        int count=0;
        if(w%4==0||h%4==0){
            count = (w*h)/2;
        }else{
            count = (w*h)/2+1;
        }
        return count;
    }
}
