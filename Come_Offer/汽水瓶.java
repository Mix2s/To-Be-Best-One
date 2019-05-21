
package src.javaTest;

import java.util.Scanner;

/*
 Scanner sc = new Scanner(System.in);
        int n=0;
        while(sc.hasNext()){
            n=sc.nextInt();
            System.out.println(count(n));
        }
 */
public class day521 {
    public static void main(String[] args) {
        int key = 0;
        int[] a = new int[10];
        int i=0;
        while (true) {
            Scanner in = new Scanner(System.in);
            if(in.hasNext()) {
                key = in.nextInt();
            }
            if (key == 0) {
                break;
            }
            a[i++] = count(key);
        }
        for (int j = 0; j < a.length; j++) {
            if (a[j] != 0) {
                System.out.println(a[j]);
            }
        }


    }
    public static int count(int n) {
        int count = 0;
        while (n > 0) {
            if (n >=3) {
                while (n >= 3) {
                    n -= 3;
                    count += 1;
                    n++;
                }
            } else {
                if (n == 2) {
                    count++;
                    return count;
                }
                if(n==1){
                    return count;
                }
            }
        }
        return 0;
    }
}

