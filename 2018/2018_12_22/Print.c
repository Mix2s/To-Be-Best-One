#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
/*
	打印整数的每一位
*/
int Print(int n){
	if (n > 9){
		Print(n / 10);
	}
	printf("%d ", n % 10);
}
int main(){
	int n;
	scanf("%d", &n);
	Print(n);
	system("pause");
	return 0;
}