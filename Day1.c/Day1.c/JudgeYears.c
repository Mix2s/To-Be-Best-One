/*
	��Ŀ����
	�ж�����Ƿ�Ϊ����
*/
#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
int main(){
	//���� �ܱ�4�������ܱ�100���� �� �ܱ�400����
	int year = 0;
	scanf("%d", &year);
	if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
	{
		printf("%dΪ����", year);
	}
	system("pause");
	return 0;
}