package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class findBorWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] str = {"abc","bca","cab"};
            int n = 3;
            char[] bor = "bca".toCharArray();
            int key = 1;
            Arrays.sort(bor);
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] arr = str[i].toCharArray();
                if (!Arrays.equals(arr, bor)) {
                    Arrays.sort(arr);
                    if (Arrays.equals(arr, bor)) {
                        list.add(str[i]);
                    }
                }
            }
            if (list.size() > 0) {
                System.out.println(list.size());
                System.out.println(list.get(key - 1));
            }else{
                return;
            }
        }
    }
}
