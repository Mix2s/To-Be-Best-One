package day_2_24;

import java.util.Scanner;

/*
 * 镜像字符串，给定两个字符串，
 * 判断第二个是否为第一个的镜像字符串，
 * 是返回yes，否返回no.
 */
public class test4 {
public static boolean count(String str1,String str2) {
	int p1=0,p2=0;
	char[] st1=str1.toCharArray();
	char[] st2=str2.toCharArray();
	for(int i=0;i<st1.length;i++) {
		if(st1[i]==st2[0]) {
			p1=1;
		}
	}
	while(p1<st1.length&&p2<st2.length) {
		if(st1[p1]==st2[p2]) {
			if(p1==st1.length) {
				p1=-1;
			}
			p1++;
			p2++;
			continue;
		}else {
			return false;
		}
	}
	return true;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入字符串");
		String str1 = scanner.next();
		String str2 =scanner.next();
		if(str1.length()-str2.length()!=0) {
			System.out.println("no");
			return;
		}
		if(str1==null||str1.length()<=0||str2==null||str2.length()<=0) {
			System.out.println("error");
		}
		boolean num = count(str1,str2);
		if(num==true) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
	}

}
