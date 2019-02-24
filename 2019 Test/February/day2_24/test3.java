package day_2_24;

import java.util.Scanner;

public class test7 {
	public static void main(String[] args) {
		/*
		 * 水仙花，即给定一个三位数，
		 * 每一位的数字立方加起来等于这个数本身。
		 */
		Scanner san = new Scanner(System.in);
		int min = san.nextInt();
		int max=san.nextInt();
		for(int mid=min;mid<max;mid++) {
			int a=mid/100;
			int b=mid%10;
			int c=mid%100/10;
			int sum=a*a*a+b*b*b+c*c+c;
			if(sum==mid) {
				System.out.println(mid);
			}
		}
		/*
		 * 从键盘输入m和n，定义n是第一个数，
		 * 之后的每个数都是前一个的平方根
			一共有m个数，计算总和。
		 * 
		 */
		
//		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		float n = scan.nextFloat();
		int m = scan.nextInt();
		float sum=n;
		for(int i=2;i<=m;i++){
			sum+=Math.sqrt(n);
			n=(float)Math.sqrt(n);
		}
		System.out.println("sum"+sum);
		
		
		
	
	}
}
