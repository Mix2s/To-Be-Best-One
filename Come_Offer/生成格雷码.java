package com.hui;

public class day62 {
    public static void main(String[] args) {
        String[] ss = getGray(2);
        for (String aa:ss){
            System.out.println(aa);
        }
    }
    public static String[] getGray(int n) {
        // write code here
        if(n==1){
            return new String[]{"0","1"};
        }
        String[] before = getGray(n-1);
        String[] cur = new String[before.length*2];     //每次一次数组长度为之前的两倍
        for(int i=0;i<before.length;i++){
            cur[i]="0"+before[i];
            cur[i+before.length]= "1"+before[before.length-1-i];
        }
        return cur;
    }
}
