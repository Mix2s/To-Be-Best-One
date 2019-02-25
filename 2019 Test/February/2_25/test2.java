package day_2_24;

import java.util.Scanner;

/*
 * 二分查找，在左区间输出0，右区间输出1.
逐渐逼近，保留6位。
注意特殊输入：
(1) key值小于输入临界最小值或者大于临界最大值。
(2) 临界最小值大于临界最大值。
(3) 两个临界值都为0，输出0。 
 */
public class test3 {
public static int comp(int key,int num) {
	if(key>=num) {
		return 1;
	}else {
		return 0;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入最小临界值");
		int a = scanner.nextInt();
		System.out.println("输入最大的临界值");
		int b = scanner.nextInt();
		System.out.println("输入比较的值");
		int key = scanner.nextInt();
		if(key<a||key>b) {
			System.out.println("error");
		}else if(key==0&&a==0&&b==0) {
			System.out.println("error");
		}else {
			while(a<=b) {
				for(int i=0;i<6;i++) {
					int num;
					num=(a+b)/2;
					System.out.println("num"+num);
					int s = comp(key,num);
					if(s==0) {
						b=num;
						System.out.println("0");
					}else {
						a=num;
						System.out.println("1");
					}
				}
				break;
			}
		}
	}

}
