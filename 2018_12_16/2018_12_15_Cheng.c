#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"

int Mult(int num){
	/*
		˼· ȷ������ �ڳ˷������������� �� �� ��
		�ɿ��Ƶ���Ϊ  �� ����Ӱ����
		���� ����  for ��һ��for ѭ���� �ڶ���forѭ����
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
	printf("�����������\n");
	scanf("%d", &num);
	Mult(num);

	system("pause");
	return 0;
}