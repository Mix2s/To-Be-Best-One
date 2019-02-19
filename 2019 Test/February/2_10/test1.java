package test;

import java.util.Random;
import java.util.Scanner;

public class day_2_19 {
	public int rubbit(int mon) {
		if(mon<=2) {
			return 1;
		}else {
			return rubbit(mon-1)+rubbit(mon-2);
		}
	}
	
	public static boolean isshuixian(int num) {
	int b=num/100;
	int s=num%100/10;
	int g=num%10;
	return Math.pow(b, 3)+Math.pow(s, 3)+Math.pow(g, 3)==num?true:false;
}
	
	
	public static void panduan(int num) {
	int b=num/100;
	int s=num%100/10;
	int g=num%10;
	if(num%9==0) {
		System.out.println(num+"能被9整除");
		if((b+s+g)%9==0) {
			System.out.println(num+"各个位数之和被9整除");
		}else {
			System.out.println(num+"各个数位不能整除");
		}
	}else {
		System.out.println("next test");
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.println("输入一个整数");
	Scanner sc = new Scanner(System.in);
	int num=sc.nextInt();
	System.out.println(num+"质因数");
	for(int i=2;i<num;i++) {
		while(num%i==0) {
			num/=i;
			System.out.println(i+"");
		}
	}
	System.out.println(""+num);
	}
}
