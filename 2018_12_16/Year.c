#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
int Judg(int year){
	if ((year%4==0)&&(year%100==0)||(year%100==0)){
		return 1;
	}
	return 0;
}
int main(){
	int year;
	printf("����һ����ݣ�");
	scanf("%d",&year);
	if (Judg(year)){
		printf("��");
	}
	else{
		printf("��");
	}
	system("pause");
	return 0;
}