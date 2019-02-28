#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
/*
	使用递归实现 N^K
*/
int power(int n, int k){
	if (n == 1){
		return 1;
	}
	else  if(k == 1){
		return n;
	}
	else{
		return n*power(n, k - 1);
	}
	
}
int main(){
	int n, k;
	scanf("%d %d", &n, &k);
	printf("%d", power(n, k));
	system("pause");
	return 0;
}