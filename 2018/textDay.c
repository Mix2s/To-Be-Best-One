#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
#include "windows.h"
#include "time.h"
/*
@author
总结 提升 问题汇总
与解决
*/


//C语言数组越界问题
int arr(){

	int i = 0;
	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	for (i = 0; i <= 12; i++){
		arr[i] = 0;
		printf("标记%d\n", i);
	}
	return 0;
}
/*
演示多个字符从两边向中间靠拢
题目要求 将多个字符从两端向中间移动
*/
int sorting(){
	
	char arr1[] = "Wu di da hui hui";
	char arr2[] = "################";
	int left = 0;
	int right = strlen(arr1) - 1;
	//int right = (sizeof(arr1) / sizeof(arr1[2])) - 2;
	while (left <= right){
		Sleep(2000);
		arr2[left] = arr1[left];
		arr2[right] = arr1[righat];
		left++;
		right--;
		system("cls");
		printf("%s\n", arr2);
	}
	return 0;
}
//计算N的阶乘
int result(){
	int res = 1;
	int i;
	int n;
	printf("输入要计算的数字:");
	scanf("%d", &n);
	for (i = 1; i <= n; i++){
		res = res*i;

	}
	printf("%d", res);

}
//n!求和
int ResSum(){
	int res = 1;
	int i;
	int n;
	int sum = 0;
	printf("输入要计算的数字:");
	scanf("%d", &n);
	for (i = 1; i <= n; i++){
		res *= i;
		sum += res;

	}
	printf("%d", sum);
}

int game(){
	int num = rand() % 100 + 1;        //产生随机数 %100取余加一 变成100以内的随机数
	int in = 0;
	while (1){						//执行逻辑判断
		printf("输入数字");
		scanf("%d",&in);
		if (in > num){
			printf("大了");
		}
		else if (in < num){
			printf("小了");
		}
		else{
			printf("对了");
			break;
		}
	}

	
}
void menu(){
	     printf("*****************（）（）********\n");
		 printf("*****  1.C数组越界 *****\n");
		 printf("*****  2.字符靠拢  *****\n");
		 printf("*****  3.N！       *****\n");
		 printf("*****  4.n!求和    *****\n");
		 printf("*****  5.猜数字    *****\n");
		 printf("*****  0.不玩了    *****\n");
		 printf("*********************（）（）****\n");

}
int main(){
	int in = 0;
	srand((unsigned)time(NULL));
	do{
		menu();
		printf("做你想做的");
		scanf("%d", &in);

		switch (in){
		case(1) : arr();
			break;
		case(2) : sorting();
			break;
		case(3) : result();
			break;
		case(4) : ResSum();
			break;
		case(5) : game();
			break;
		case(0) :
			printf("谢谢合作");
			break;
		default:
			printf("请好好选择");
			break;
		}
	} while (in);
	system("pause");
	return 0;
	
}
