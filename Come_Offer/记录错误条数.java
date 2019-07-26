package Everyday;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class errorCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> errorMap = new LinkedHashMap<>();
        while(sc.hasNext()) {
            String ss = sc.next();
            int errorNum = sc.nextInt();

            String[] strArr = ss.split("\\\\");
            String errorName = strArr[strArr.length - 1];
            if (errorName.length() > 16) {
                errorName = errorName.substring(errorName.length() - 16);
            }
            String str = errorName + " " + errorNum;

            int value = 1;
            if (errorMap.containsKey(str)) {
                errorMap.put(str, errorMap.get(str) + 1);
            } else {
                errorMap.put(str, value);
            }
        }
            int count = 0;
            for(String s:errorMap.keySet()){
                count++;
                if(count>(errorMap.keySet().size()-8)){
                    System.out.println(s+" "+errorMap.get(s));
                }
            }
        }
    }

