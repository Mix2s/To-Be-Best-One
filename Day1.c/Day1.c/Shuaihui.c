/*
	��Ŀ����
	�ж�100-200֮�ڵ�����
	ʵ�� �Ż�
*/

#define _CRT_SECURE_NO_WARNINGS 1

#include "stdio.h"
#include "stdlib.h"
#include "math.h"
int main(){

	int i=0;
	int j=0;
	for (i = 100; i <= 200; i++){
		int count = 0; //�ֲ�����
		for (j = 2; j < i; j++){
			if (i%j == 0){
				count++;
				break;
			}
		}
		if (count == 0){
			printf("��%dΪ����\n",i);
		}
	}
	//for (i = 100; i <= 200; i++)
	//{          //�ж�i�Ƿ�Ϊ����
	//	for (j = 2; j <= sqrt(i); j++)    //���Ϊ ���һ�� Ѱ����Ч�߳�
	//	{   //for(j=101;j<=i-1;j+=2)   ֻ���������ֵ��ж�
	//		//for(j=2;j<=i-1;j++)      Ч�ʵ��о�������һһ�Ա�
	//		//�ж�2��n-1֮������
	//		if (i % j == 0)
	//		{//J���Ϊn-1
	//			break;
	//		}
	//	}
	//if (j>sqrt(i))  
	//	//��j==i�� ���

	//	{//���i=j���ܱ��κ�һ��J����
	//		printf("%d\n", i);
	//	}
	//}
	
	system("pause");
	printf("END");
	return 0;
}