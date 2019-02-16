package day_2_16;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			test2 t2 = new test2();
			t2.chengji();
	}
	void chengji() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入学生成绩");
		int a=sc.nextInt();
		if(a>=90&&a<=100) {
			System.out.println("该学生的成绩是"+a+"\t成绩优秀");
		}else if(a>=80&&a<90){
            System.out.println("该学生的成绩是"+a+"\t成绩良好");
        }
        else if(a>=70&&a<80){
            System.out.println("该学生的成绩是"+a+"\t成绩中等");
        }
        else if(a>=60&&a<70){
            System.out.println("该学生的成绩是"+a+"\t成绩及格");
        }
        else{
            System.out.println("该学生的成绩是"+a+"\t成绩不及格");
        }
    }
 
}
