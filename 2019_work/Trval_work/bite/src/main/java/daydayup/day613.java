package daydayup;

import java.util.Scanner;

public class day613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            encry(str);
        }
    }
//HELLO WORLD<br/>SNHJ
    private static void encry(String str) {
        char[] a = new char[26];
        for(int i=0;i<26;i++){
            a[i] = (char)('A'+i);
        }
        char[] b = new char[26];
        for(int i=0;i<26;i++){
            if(i<5){
                b[i] = (char)('V'+i);
            }else {
                b[i] = (char) ('A' + i - 5);
            }
        }
        StringBuffer sb = new StringBuffer();
        char[] c = str.toCharArray();
        for(int i=0;i<c.length;i++){
            for(int j=0;j<26;j++){
                if(str.charAt(i)==' '){
                    sb.append(" ");
                    break;
                }
                if (str.charAt(i)-a[j]==0) {
                    sb.append(b[j]);
                }
            }
        }
        System.out.println(sb);
    }
}
