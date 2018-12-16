#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"

int Mult(int num){
	/*
		思路 确定变量 在乘法表中两个变量 行 和 列
		可控制的量为  行 ，行影响列
		利用 两个  for 第一个for 循环行 第二个for循环列
	*/
	int Line=0;
	int Colu=0;
	for (Line = 1; Line<= num; Line++){
		for (Colu = 1; Colu <=Line; Colu++){
			printf("%d*%d=%d ",Line,Colu,(Line*Colu));
		}
		printf("\n");
	}

}
int main(){
	int num;
	printf("请输入参数：\n");
	scanf("%d", &num);
	Mult(num);

	system("pause");
	return 0;
}