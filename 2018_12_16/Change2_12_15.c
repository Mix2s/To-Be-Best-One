#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"

int  Change(int* a,int* b){
	/*
		�����ķ�ʽΪ��ַ����
		��Ϊ�ں����� ����Ϊ�ββ��ܷ���
		����ͨ���Ե�ַ�ı���ɽ���

	*/
	int temp=0 ;
	temp = *a;
	*a = *b;
	*b = temp;
}
int main(){
	int a;
	int b;
	printf("���뽻�������֣�");
	scanf("%d %d", &a, &b);
	Change(&a,&b);
	printf("%d %d", a, b);
	system("pause");
	return 0;
}