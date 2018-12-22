#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
/*
	
*/
int addition(int n){
	if (n <= 9){
		return n;
	}else{
		return n % 10 + addition(n / 10);
	}
}
int main(){
	int n;
	scanf("%d", &n);
	printf("%d", addition(n));
	system("pause");
	return 0;
}