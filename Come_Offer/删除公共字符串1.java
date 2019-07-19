

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String str1 = sc.nextLine();
            StringBuffer sb = new StringBuffer(str);
            char[] sb1 = str1.toCharArray();
            for(int i=0;i<sb.length();i++){
                for(int j=0;j<sb1.length;j++){
                    if(sb.charAt(i)!=' '){
                        if(sb.charAt(i)==sb1[j]){
                            sb.deleteCharAt(i);
                        }
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
