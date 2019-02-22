package day_2_22;

import java.util.HashSet;
/*
 4.对于一个字符串，请设计一个高效算法
 找到第一次重复出现的字符。
给定一个字符串(不一定全为字母)A及它的长度n。
请返回第一个重复出现的字符。
保证字符串中有重复字符，字符串的长度小于等于500。

方法1：这是前辈给出的算法，利用HashSet的特性，
即不允许重复放入元素，
所以一旦检测到重复元素就返回false。
对于本道题来说，这种方法简洁且容易理解，
能高效实现功能，但是这种方法普适性较差。

 */
public class test3 {
public static char findFirstRepeat(String A,int n) {
	HashSet hs = new HashSet();
	int length=A.length();
	//利用头Char Array()将String类型转化为char类型
	char [] a=A.toCharArray();
	for(int i=0;i<length;i++) {
		boolean b=hs.add(a[i]); //hashSet不能含有重复元素
		if(b==false) {
			return a[i];
		}
	}
	return '0';
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String A="16i99922";
			int n=A.length();
			char b=findFirstRepeat(A, n);
			System.out.println(b);
	}

}
