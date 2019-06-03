package com.hui;

import java.util.Scanner;

public class day62 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                String c = sc.next();
                Squart(n,c);
        }
        public static void Squart(int n,String a){
            for(int i=0;i<n;i++){
                System.out.print(a);
            }
            System.out.println();
                for(int i=0;i<Math.round((double) n/2)-2;i++){
                    System.out.print(a);
                    for(int j=1;j<n-1;j++){
                        System.out.print(" ");
                    }
                    System.out.println(a);
                }
            for(int i=0;i<n;i++){
                System.out.print(a);
            }
        }
    }



