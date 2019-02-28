#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
int init(int arr[],int len){
	int i=0;
	for (i = 1; i <= len; i++){
		printf("赋初值：");
		scanf("%d", &arr[i]);
	}
}
int empty(int arr[],int len){
	int i = 0;
	for (i = 1; i <= len; i++){
		arr[i] = 0;
	}
}
int reverse(int arr[], int len){
	int i = 0;
	for (len - 1; len > 0;len--){
		printf("逆置数组");
		scanf("%d", &arr[i]);
	}
}
int menu(){
	printf("/////  选择操作     /////\n");
	printf("///// 1.初始化数组  /////\n ");
	printf("///// 2.清空数组    /////\n");
	printf("///// 3.逆置数组    /////\n");
}
int main(){
	int len;
	int arr[100];

	int input;
	printf("指定数组长度");
	scanf("%d", &len);
	menu();
	scanf("%d",&input);
	switch (input){
	case 1:
		init(arr,len);
		break;
	case 2:
		empty(arr, len);
		break;
	case 3:
		reverse(arr, len);
		break;
	default:
		break;
	}



	printf("%d", arr[4]);
	system("pause");
	return 0;
}