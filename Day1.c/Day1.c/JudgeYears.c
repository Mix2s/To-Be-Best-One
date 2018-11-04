/*
	题目描述
	判断年份是否为闰年
*/
#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
int main(){
	//闰年 能被4整除不能被100整除 且 能被400整除
	int year = 0;
	scanf("%d", &year);
	if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
	{
		printf("%d为闰年", year);
	}
	system("pause");
	return 0;
}