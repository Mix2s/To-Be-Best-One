/*
	题目描述
	输出乘法口诀表
*/

#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"

int main(){
	int i=0;
	int j = 0;
	short max = 0;
	for (i = 1; i <= 9; i++){           //i控制行 j控制了列
		for (j = 1; j<=i; j++){
			max = i*j;
			printf("%d*%d=%d\t", i, j, max);
		}
		printf("\n");
	}
	
	system("pause");
}