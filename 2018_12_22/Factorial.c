#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
/*
   主要完成 斐波那契数列
   1 1 2 3 5 8 13 21 34.。。
*/

int Factorial_Non(int  n){
	int f1 = 1;
	int f2 = 1;
	int f3,i;
	if (n <= 2){
		return  1;
	}
	else{
		for (i = 1; i <= n; i++){
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
	}
	return f3;
}

int Factorial(int n){
	if (n <= 2){
		return 1;
	}else{
		return Factorial(n - 1) + Factorial(n-2);
	}
	
}
int main(){
	int n;
	scanf("%d", &n);
	printf("%d", Factorial(n));
	system("pause");
	return 0;
}