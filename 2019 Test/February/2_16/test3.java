package day_2_16;

import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("年");
		int year=sc.nextInt();
		System.out.println("月");
		int month = sc.nextInt();
		System.out.println("日");
		int day=sc.nextInt();
		int days=0;
		switch(month) {
		case 12:days+=30;
		case 11:days+=31;
		case 10:days+=30;
		case 9:days+=31;
		case 8:days+=31;
		case 7:days+=30;
		case 6:days+=31;
		case 5:days+=30;
		case 4:days+=31;
		case 3:
			if((year%4==0&&year%100!=0)||(year%400==0)) {
				days+=29;
			}else {
				days+=28;
			}
		case 2:days+=31;
		case 1:days+=day;
		}
		System.out.println("第"+days+"天");
	}
}
