package bite.note4;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
           int n = sc.nextInt();
           int invalid = 0;
           Map<String,Integer> map = new LinkedHashMap<>();
           for(int i=0;i<n;i++){
               map.put(sc.next(),0);
           }
           int n2 = sc.nextInt();
           for(int i=0;i<n2;i++){
               String s = sc.next();
               if(map.containsKey(s)){
                   map.put(s,map.get(s)+1);
               }else{
                   invalid++;
               }
           }
           for(String key:map.keySet()){
               System.out.println(key+" : "+map.get(key));
           }
            System.out.println("Invalid : "+invalid);
        }
    }
}
