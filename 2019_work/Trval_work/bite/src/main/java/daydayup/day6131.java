package daydayup;

import java.util.Scanner;

public class day6131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            screen_Bead(str1,str2);
        }
    }
//ppRYYGrrYBR2258<br/>YrR8RrY
    private static void screen_Bead(String str1, String str2) {
        StringBuffer sb1 = new StringBuffer(str1);
        StringBuffer sb2 = new StringBuffer(str2);
        int count = 0;
        for(int i=0;i<sb2.length();i++){
            for(int j=0;j<sb1.length();j++){
                if(sb2.charAt(i)==sb1.charAt(j)){
                        sb1.deleteCharAt(j);
                        ++count;
                        break;
                }
            }
        }
        if(sb1.length()-1==count){
            System.out.println("Yes"+" "+sb1.length());
        }else{
            System.out.println("NO"+" "+(sb2.length()-count));
        }
    }
}

