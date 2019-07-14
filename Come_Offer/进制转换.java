import java.util.Scanner;

public class ChangeTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String ss = sc.next();
            String str = ss.substring(2,ss.length());
            System.out.println(Integer.parseInt(str,16));
        }
    }
}
