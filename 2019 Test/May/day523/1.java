package src.javaTest;

import java.util.Scanner;

public class day5234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            str(str);
        }
    }
    public static String str(String str){
        char[] array = str.toCharArray();
        char[] a = new char[str.length()];
        char[] b = new char[str.length()];
        int count=0;
        for(int i=0;i<str.length();i++){
                count++;
                if(array[i]=='.'){
                    break;
                }
        }
        for(int i=0;i<count;i++){
            a[i]=array[i];
        }
        for(int i=count;i<array.length;i++){
            b[i-count]=array[i];

        }
        for(int i=0;i<array.length;i++){
           for(int j=0;j<array.length;j++){
              if((a[i]!=' ')&&(b[i]!=' ')){
                  if(a[i]==b[j]){
                      a[i]=' ';
                  }
              }
           }
        }
       String ss = new String(a);
        System.out.print(ss);
        return ss;
    }
}
