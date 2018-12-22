#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
int Fact_Non(int n){
	int i;
	int ret=1;
	for (i = 1; i <= n; i++){
		ret *= i;
	}
	return ret;
}
int Fact(int n){
	if (n <= 9){
		return n;
	}
	return n*Fact(n - 1);
}
int main(){
	int n;
	scanf("%d",&n);
	printf("%d", Fact(n));
	system("pause");
	return 0;
}