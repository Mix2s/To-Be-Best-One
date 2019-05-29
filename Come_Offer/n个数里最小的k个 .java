package src.javadyday;

import java.util.Scanner;

public class day55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            small(str);
        }
    }

    public static void small(String str) {
        String[] ss = str.split(" ");
        int[] arr = new int[ss.length-1];
        int k=0;
        for (int i = 0; i < ss.length; i++) {
            if (i < ss.length -1) {
                arr[i] = Integer.parseInt(ss[i]);
            } else {
                 k = Integer.parseInt(ss[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
       for(int i=0;i<k;i++){
           System.out.print(arr[i]+" ");
       }
    }
}
