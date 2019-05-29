package src.javadyday;

import java.util.LinkedList;
import java.util.Scanner;

public class day529tt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            if (n > 999) {
                n = 999;
            }
            if (n == 0) {
                System.out.println(0);
            }
            deleteArray(n);
        }
    }
    public static void deleteArray(int n){
        LinkedList<Integer> header = new LinkedList();
        for(int i=0;i<n;i++){
            header.add(i);
        }
        int count=0;
      while(header.size()>1){
          count = (count+2)%header.size();
          header.remove(count);
      }
        System.out.println(header.get(0));
    }
}
