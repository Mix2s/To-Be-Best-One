package bite.note6;

import java.util.Scanner;

public class mimahege {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            if(change(str)&&change1(str)&&change2(str)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
    public static boolean change2(String str){
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        char[] cc = str.toCharArray();
        for(int i=0;i<cc.length;i++) {
            if (cc[i] >= '0' && cc[i] <= '9') {
                countA = 1;
            } else if (cc[i] >= 'A' && cc[i] <= 'Z') {
                countB = 1;
            }else if (cc[i] >= 'a' && cc[i] <= 'z') {
                countC = 1;
            }else {
                countD = 1;
                }
            }

        if((countA+countB+countC+countD)<3){
             return false;
        }
        return true;
    }
    public static boolean change1(String str){
        if (str==null||str.length()<=8){
            return false;
        }
        return true;
    }
    public static boolean  change(String str){
        for(int i=0;i<str.length()-2;i++){
            String ss = str.substring(i,i+3);
            if(str.substring(i+1).contains(ss)){
                return false;
            }
        }
        return true;
    }
}
