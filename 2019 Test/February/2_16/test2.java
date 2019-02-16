package day_2_16;

import java.util.Scanner;

public class test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("输入一个0~99999之间的任意数字");
		int number=sc.nextInt();
		if(number/10000>=1&&number/10000<10) {
			System.out.println(number+"\t是5位数字");
		}else if(number/1000>=1) {
			System.out.println(number+"\t是4位数字");
		}else if(number/100>=1) {
			System.out.println(number+"\t是3位数字");
		}else if(number/10>=1) {
			System.out.println(number+"\t是2位数字");
		}else if(number/1>=1) {
			System.out.println(number+"\t是1位数字");
		}
	}

}
