

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String ss = sc.nextLine();
            String[] strArr = ss.split(" ");
            StringBuffer sb = new StringBuffer();
            for(int i=strArr.length-1;i>=0;i--){
                sb.append(strArr[i]);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}
