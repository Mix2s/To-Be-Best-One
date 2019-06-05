package com.wang;

public class day65 {
    public static void main(String[] args) {
            addAB(3,3);
        System.out.println((2&1)<<1);
    }
    public static void addAB(int A, int B) {
        int a1 = A^B;
        int b1 = (A&B)<<1;
        while(B>0){
           a1 = A^B;
           b1 = (A&B)<<1;
           A = a1;
           B = b1;
        }
        System.out.println(A);
    }
}
