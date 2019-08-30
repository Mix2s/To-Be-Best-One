package main.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class niuke {
   static Map<Character,Integer> map =  new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String xx = sc.nextLine();
            int n = Integer.parseInt(xx);
            String[] ss = new String[n];
            /**
             * 待测目标传入数组
             */
            for(int i=0;i<n;i++){
                ss[i] = sc.nextLine();
            }
            /*
                字典传入map
             */
            for(int i=0;i<str.length();i++){
                map.put(str.charAt(i),i);
            }
            /**
             * 比较过程
             */
            String temp = "";
            for(int i=0;i<ss.length-1;i++){
                for(int j=0;j<ss.length-1-i;i++){
                    if(change(ss[i],ss[j])==1){
                        temp = ss[i];
                        ss[i] = ss[j];
                        ss[j] = temp;
                    }
                }
            }
            for(int i=0;i<ss.length;i++){
                System.out.println(ss[i]);
            }
        }
    }

    /**
     * 传入字符串s1>s2
     * @param s1
     * @param s2
     * @return
     */
    public static int change(String s1,String s2){
        for(int i=0;i<s1.length();i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(map.get(a)>map.get(b)){
                return 0;
            }if(a==b){
                continue;
            }else{
                break;
            }
        }
        return 1;
    }
}
