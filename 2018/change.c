#define _CRT_SECURE_NO_WARNINGS 1
#define random(x) (rand()%x)   //���ú궨����������
#include "stdlib.h"

#include "stdio.h"
#include "stdlib.h"


/*
��ַ�ռ䲻��
��ʼ�����������ڻ�����
*/
int change2(){
	int x;
	int y;
	printf("���룻");
	scanf("%d %d", &x, &y);
	printf("����֮ǰ%d,%d\n", x, y);   // x1  y2
	x = x + y;  //3=1+2;
	y = x - y; //3-2=1
	x = x - y;
	printf("����֮ǰ%d,%d\n", x, y);
	return 0;
};


/*
	���������� ��ƿ��
*/
int change1(){
	int x;
	int y;
	printf("���룻");
	scanf("%d %d", &x, &y);
	printf("����֮ǰ%d,%d\n", x, y);
	int z;
	z = x;
	x = y;
	y = z;
	printf("����֮��%d,%d\n", x, y);
	return 0 ;

}                                



/*
	�����Լ��
	շת���
	�����������������
*/
int conve(){
	int f1=1;
	int f2=1;
	printf("���룻");
	scanf("%d %d", &f1, &f2);
	int f3 = f1%f2;
	while (f3!=0){
		f1 = f2;
		f2 = f3;
		f3 = f1%f2;
	}
	printf("%d", f2);

}

/*
	������
*/
int exchanger(int x,int y){
	int z;
	z = x;
	x = y;
	y = z;
	return 0;
}


/*
10������ѡ������
ѡ�����򷽷�
*/

int select1(){
	printf("10������ѡ������һ�� �����������\n");
	int i;
	int temp;
	int j;
	int arr[10] = {0};
	printf("����ǰ\n");
	for(i = 0; i <= 9; i++){
		arr[i] = random(100);
		printf("%d,", arr[i]);
	}
	
	int len = sizeof(arr) / sizeof(arr[0]);   //�ӵ�1�����ֿ�ʼ
	for (i = 0; i <= len - 1; i++){				//ÿ���������������ֱȽ�i-1�� ����ѭ��i-2��
		for (j = 0; j <= len-2; j++){
			if (arr[j] < arr[j + 1]){
				exchanger(arr[i], arr[i + 1]);
			}
		}
	}
	printf("�����\n ���ֵ%d",arr[0]);
	for (i = 0; i <= 9; i++){
		printf("%d,", arr[i]);
	}
		
	return 0;
}
int main(){
	




	int in;
	printf("***************\n");
	printf("**����Ҫ�ļ���**\n");
	printf("**1 Ϊ�Ƚϼ���**\n");
	printf("**2 Ϊ�������**\n");
	printf("**3 Ϊ���Լ��**\n");
	printf("***************");
	scanf("%d", &in);
	switch(in){
	case 1:
		printf("***************\n");
		printf("**ѡ�����򷽷�**\n");
		printf("**1.��ַ�������**\n");
		printf("**2.��ƿ�Ӽ���**\n");
		printf("***************");
		scanf("%d", &in);
		if (in == 1){
			change1();
		}
		if (in == 2){
			change2();
		}
		break;
	case  2:
		select1();
		break;

	case 3:
		conve();
		break;
	default:
		printf("�������");
		break;

	}

	
	system("pause");
	return 0; 
	
	

	
}