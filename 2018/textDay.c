#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
#include "windows.h"
#include "time.h"
/*
@author
�ܽ� ���� �������
����
*/


//C��������Խ������
int arr(){

	int i = 0;
	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	for (i = 0; i <= 12; i++){
		arr[i] = 0;
		printf("���%d\n", i);
	}
	return 0;
}
/*
��ʾ����ַ����������м俿£
��ĿҪ�� ������ַ����������м��ƶ�
*/
int sorting(){
	
	char arr1[] = "Wu di da hui hui";
	char arr2[] = "################";
	int left = 0;
	int right = strlen(arr1) - 1;
	//int right = (sizeof(arr1) / sizeof(arr1[2])) - 2;
	while (left <= right){
		Sleep(2000);
		arr2[left] = arr1[left];
		arr2[right] = arr1[right];
		left++;
		right--;
		system("cls");
		printf("%s\n", arr2);
	}
	return 0;
}
//����N�Ľ׳�
int result(){
	int res = 1;
	int i;
	int n;
	printf("����Ҫ���������:");
	scanf("%d", &n);
	for (i = 1; i <= n; i++){
		res = res*i;

	}
	printf("%d", res);

}
//n!���
int ResSum(){
	int res = 1;
	int i;
	int n;
	int sum = 0;
	printf("����Ҫ���������:");
	scanf("%d", &n);
	for (i = 1; i <= n; i++){
		res *= i;
		sum += res;

	}
	printf("%d", sum);
}

int game(){
	int num = rand() % 100 + 1;        //��������� %100ȡ���һ ���100���ڵ������
	int in = 0;
	while (1){						//ִ���߼��ж�
		printf("��������");
		scanf("%d",&in);
		if (in > num){
			printf("����");
		}
		else if (in < num){
			printf("С��");
		}
		else{
			printf("����");
			break;
		}
	}

	
}
void menu(){
	     printf("*************************\n");
		 printf("*****  1.C����Խ�� *****\n");
		 printf("*****  2.�ַ���£  *****\n");
		 printf("*****  3.N��       *****\n");
		 printf("*****  4.n!���    *****\n");
		 printf("*****  5.������    *****\n");
		 printf("*****  0.������    *****\n");
		 printf("*************************\n");

}
int main(){
	int in = 0;
	srand((unsigned)time(NULL));
	do{
		menu();
		printf("����������");
		scanf("%d", &in);

		switch (in){
		case(1) : arr();
			break;
		case(2) : sorting();
			break;
		case(3) : result();
			break;
		case(4) : ResSum();
			break;
		case(5) : game();
			break;
		case(0) :
			printf("лл����");
			break;
		default:
			printf("��ú�ѡ��");
			break;
		}
	} while (in);
	system("pause");
	return 0;
	
}
