package test;

import java.util.Random;
import java.util.Scanner;

public class day_2_18_1 {
	public static boolean isyinzi(int num) {
		int sum=0;
		for(int d=num-1;d>=1;d--) {
			if(num%d==0) {
				sum+=d;
			}
		}
		return sum==num;
	}
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		System.out.println("输入一个整数");
//		int read = sc.nextInt();
//		System.out.println("方案一");
//		StringBuilder sb = new StringBuilder(String.valueOf(read));
//		System.out.println(sb.reverse());
//		
//		String str = read+"";
//		char fuzu[]=str.toCharArray();
//		String temp="";
//		for(int a=fuzu.length-1;a>=0;a--) {
//			temp=temp+fuzu[a];
//		}
//		System.out.println("方案二");
//		System.out.println(temp);
		
//		int a=1;
//		int sum=0;
//		while(a<=200) {
//			if(a%3==0) {
//				sum=sum+a;
//			}
//			a++;
//		}
//				System.out.println(sum);
		
//		for(int g=0;g<=20;g++) {
//			for(int m=0;m<=33;m++) {
//				for(int x=0;x<=100-g-m;x++) {
//					if(x%3==0&&5*g+m*3+x/3==100&&g+m+x==100) {
//						System.out.println("公鸡"+g+"母鸡"+m+"小鸡");
//					}
//				}
//			}
//		}
		
//		int s=-1;
//		for(int a=1;a<5;a++) {
//			s+=2;
//			for(int b=1;b<=s;b++) {
//				System.out.print("#");
//			}
//			System.out.println();
//		}
//	}
		
		
//		int num;
//		Random rd = new Random();
//		num=1+rd.nextInt(Integer.MAX_VALUE);
//		System.out.println("原本数字为"+num);
//		while(num!=1) {
//			System.out.println("产生的新数字"+num);
//			if(num%2==0) {
//				num=num/2;
//			}else {
//				num=num*3+1;
//			}
//		}
//		System.out.println(num);
		
		
		for(int a=1;a<=1000;a++) {
			int num=a;
			if(isyinzi(num)) {
				System.out.println(num);
			}
		}
	 }
}
