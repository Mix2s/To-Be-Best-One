package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class changeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            replaceSpace(sc.nextLine(),sc.nextInt());
        }
    }
    public static String replaceSpace(String iniString, int length) {
        /*String str = iniString.replace(" ","%20");
        System.out.println(str);
        return str;*/

        List<String> list = new ArrayList<>();
        char[] str = iniString.toCharArray();
        for(int i=0;i<length;i++){
            if(str[i]==' '){
               list.add("%20");
            }
            list.add(String.valueOf(str[i]));
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        System.out.println(sb);
        return null;
    }
}
