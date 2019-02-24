package day_2_24;

import java.util.Scanner;

/*
 * 给定一个正整数，编写程序计算有多少对质数的和等于这个输入的正整数，
 * 并输出结果，输出值小于1000. 
 */
public class test2 {
	public static boolean isPrime(int number) {
		if(number<2) {
			return false;
		}
		for(int i=2;i<number;i++) {
			if(number%i==0) {
				return false;
			}else {
				continue;
			}
		}
		return true;
	}
private static int count(int number) {
	int count=0;
	for(int i=2;i<number;i++) {
		for(int j=2;j<=number/2;j++) {
		if(isPrime(i)&&isPrime(j)&&(i+j)==number) {
			count++;
		}
	}
 }
	return count;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入给定的数字");
		int a = scanner.nextInt();
		int count = count(a);
		System.out.println("count="+count);
	}

}
