package com.hui;

import java.util.Scanner;

public class longlongmath {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while(true) {
                String addend = sc.nextLine();
                String augend = sc.nextLine();
                String restult = addend.length() >= augend.length() ?
                        (AddLongInteger(addend, augend)) : (AddLongInteger(augend, addend));
                System.out.println(restult);
            }
    }
    public static String AddLongInteger(String addend,String augend){
        int len1 = addend.length();
        int len2 = augend.length();
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len1];
        for(int i=0;i<len1;i++){
            arr1[i]=Integer.parseInt
                    (new StringBuffer().append(addend.charAt(i)).toString());
        }
        for(int j=0;j<len2;j++){
            if(j<len1-len2){
                arr2[j]=0;
            }
            arr2[j+len1-len2] = Integer.parseInt(new StringBuffer().append(augend.charAt(j)).toString());
        }
        int[] result = new int[arr1.length];
        for(int i =0;i<arr2.length;i++){
            result[i]=arr1[i]+arr2[i];
        }
        StringBuffer sb = new StringBuffer();
        for(int i=arr2.length-1;i>=1;i--){
            if(result[i]>=10){
                result[i-1]+=1;
                result[i]-=10;
            }
            sb.append(result[i]);
        }
        if(result[0]>=10){
            sb.append(result[0]-10+"1");
        }else{
            sb.append(result[0]);
        }
        return sb.reverse().toString();
    }
}


package com.hui;

import java.math.BigInteger;
import java.util.Scanner;
public class day621 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String s1 = input.next();
            String s2 = input.next();
            BigInteger num1 = new BigInteger(s1);
            BigInteger num2 = new BigInteger(s2);
            System.out.println(num1.add(num2));
        }
    }
}

