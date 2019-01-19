#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
#include "assert.h"
void rotate(char *pstr, int key, int sz){
	assert(pstr != NULL);
	int i = 0;
	int j = 0;
	for (i = 0; i < key; i++){
		char tmp = pstr[0];
		for (j = 0; j < sz - 1; j++){
			pstr[j] = pstr[j + 1];
		}
		pstr[sz - 1] = tmp;
	}
}
void reserve(char *left, char *right){
	while (left < right){
		char tmp = *left;
		*left = *right;
		left++;
		right--;
	}
}
void left_remove(char *p, int key, int sz){
	reserve(p, p + (sz - 1));
	reserve(p, p + key - 1);
	reserve(p + key - 1, p + (sz - 1));
}

void remove_1(char arr[], int key){
	char arr1[5] = { 0 };
	char *mov1 = arr;
	char *mov2 = arr;
	char *res1 = arr1;
	char *res2 = arr1;
	while (key--){
		*res1++ = *mov2++;
	}
	while (*mov2){
		*mov1++ = *mov2++;
	}
	while (*mov1){
		*mov1++ = *res2++;
	}
	*mov1 = '\0';
}
int main(){

	char str[] = "ABCD";
	int key = 0;
	int sz = sizeof(str) / sizeof(str[0])-1;
	printf("请输入旋转字符串个数\n");
	scanf("%d", &key);
	left_remove(str, sz, key);
	//remove_1(str, key);
	printf("%s", str);

	

	system("pause");
	return 0;
}
