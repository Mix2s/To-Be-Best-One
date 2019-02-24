package day_2_24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Java的一维数组在不知道长度的情况下怎样声明？
 */
public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			List<Integer> list = new ArrayList<Integer>();
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入数组");
			while(true) {
				int a=scanner.nextInt();
				if(a==0) {
					break;
				}else {
					list.add(a);
				}
			}
			int size=list.size();
			
			Integer[]  array = (Integer[])list.toArray(new Integer[size]);
			for(int i=0;i<array.length;i++) {
				System.out.println(array[i]+"");
			}
	}

}
