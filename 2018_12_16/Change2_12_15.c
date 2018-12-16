#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"

int  Change(int* a,int* b){
	/*
		交换的方式为地址交换
		因为在函数中 交换为形参不能返回
		所以通过对地址改变完成交换

	*/
	int temp=0 ;
	temp = *a;
	*a = *b;
	*b = temp;
}
int main(){
	int a;
	int b;
	printf("输入交换的数字：");
	scanf("%d %d", &a, &b);
	Change(&a,&b);
	printf("%d %d", a, b);
	system("pause");
	return 0;
}