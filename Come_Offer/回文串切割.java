package Everyday;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Vector;

public class StringQiege {
    public static void main(String[] args) {
        System.out.println(minDistance("abaaa","a"));
    }
    public static int minDistance(String word1, String word2) {
        if(word1.length()==0||word2.length()==0){
            return Math.max(word1.length(),word2.length());
        }
        int[][] arr = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            arr[i][0] = i;
        }
        for(int j=0;j<=word2.length();j++){
            arr[0][j] = j;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                int del = arr[i-1][j]+1;
                int add = arr[i][j-1]+1;
                int ch = arr[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1);
                arr[i][j] = Math.min(Math.min(del,add),ch);
            }
        }
        return arr[word1.length()][word2.length()];
    }
}
