#define _CRT_SECURE_NO_WARNINGS 1
#define random(x) (rand()%x)   //利用宏定义产生随机数
#include "stdlib.h"

#include "stdio.h"
#include "stdlib.h"


/*
地址空间不变
初始化两个变量在基础上
*/
int change2(){
	int x;
	int y;
	printf("输入；");
	scanf("%d %d", &x, &y);
	printf("传入之前%d,%d\n", x, y);   // x1  y2
	x = x + y;  //3=1+2;
	y = x - y; //3-2=1
	x = x - y;
	printf("传入之前%d,%d\n", x, y);
	return 0;
};


/*
	交换两个数 空瓶子
*/
int change1(){
	int x;
	int y;
	printf("输入；");
	scanf("%d %d", &x, &y);
	printf("传入之前%d,%d\n", x, y);
	int z;
	z = x;
	x = y;
	y = z;
	printf("传入之后%d,%d\n", x, y);
	return 0 ;

}                                



/*
	求最大公约数
	辗转相除
	利用两个数反复相除
*/
int conve(){
	int f1=1;
	int f2=1;
	printf("输入；");
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
	交换器
*/
int exchanger(int x,int y){
	int z;
	z = x;
	x = y;
	y = z;
	return 0;
}


/*
10个数中选择最大的
选择排序方法
*/

int select1(){
	printf("10个数中选择最大的一个 并且排序输出\n");
	int i;
	int temp;
	int j;
	int arr[10] = {0};
	printf("排序前\n");
	for(i = 0; i <= 9; i++){
		arr[i] = random(100);
		printf("%d,", arr[i]);
	}
	
	int len = sizeof(arr) / sizeof(arr[0]);   //从第1个数字开始
	for (i = 0; i <= len - 1; i++){				//每个数字与后面的数字比较i-1次 整体循环i-2次
		for (j = 0; j <= len-2; j++){
			if (arr[j] < arr[j + 1]){
				exchanger(arr[i], arr[i + 1]);
			}
		}
	}
	printf("排序后\n 最大值%d",arr[0]);
	for (i = 0; i <= 9; i++){
		printf("%d,", arr[i]);
	}
		
	return 0;
}
int main(){
	




	int in;
	printf("***************\n");
	printf("**你想要的计算**\n");
	printf("**1 为比较计算**\n");
	printf("**2 为排序计算**\n");
	printf("**3 为最大公约数**\n");
	printf("***************");
	scanf("%d", &in);
	switch(in){
	case 1:
		printf("***************\n");
		printf("**选择排序方法**\n");
		printf("**1.地址不变计算**\n");
		printf("**2.空瓶子计算**\n");
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
		printf("出门左拐");
		break;

	}

	
	system("pause");
	return 0; 
	
	

	
}