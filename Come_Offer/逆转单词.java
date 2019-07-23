package main.java;

import java.util.Scanner;

public class reveseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()){
            char[] ss = sc.nextLine().toCharArray();
            for(int i=0;i<ss.length;i++){
                if((ss[i]>='a'&&ss[i]<='z')||(ss[i]>='A'&&ss[i]<='Z')){

                }else{
                    ss[i]=' ';
                }
            }
            String str = String.valueOf(ss).trim();
            String[] split = str.split("\\s+");
            for(int i=split.length-1;i>=0;i--){
                sb.append(split[i]+" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
