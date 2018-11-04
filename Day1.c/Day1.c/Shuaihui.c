/*
	题目描述
	判断100-200之内的素数
	实现 优化
*/

#define _CRT_SECURE_NO_WARNINGS 1

#include "stdio.h"
#include "stdlib.h"
#include "math.h"
int main(){

	int i=0;
	int j=0;
	for (i = 100; i <= 200; i++){
		int count = 0; //局部变量
		for (j = 2; j < i; j++){
			if (i%j == 0){
				count++;
				break;
			}
		}
		if (count == 0){
			printf("该%d为素数\n",i);
		}
	}
	//for (i = 100; i <= 200; i++)
	//{          //判断i是否为素数
	//	for (j = 2; j <= sqrt(i); j++)    //类比为 面积一定 寻找有效边长
	//	{   //for(j=101;j<=i-1;j+=2)   只做奇数部分的判断
	//		//for(j=2;j<=i-1;j++)      效率低列举所有数一一对比
	//		//判断2到n-1之间素数
	//		if (i % j == 0)
	//		{//J最大为n-1
	//			break;
	//		}
	//	}
	//if (j>sqrt(i))  
	//	//（j==i） 相等

	//	{//如果i=j则不能被任何一个J整除
	//		printf("%d\n", i);
	//	}
	//}
	
	system("pause");
	printf("END");
	return 0;
}