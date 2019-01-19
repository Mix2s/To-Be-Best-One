#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include "stdlib.h"
int judge(char *str1, char *str2){
	int i = 0;
	int j = 0;
	int len = strlen(str1);
	for (i = 0; i < len - 1; i++){
		int tmp = str1[0];
		for (j = 0; j < len - 1; j++){
			str1[j] = str1[j + 1];
		}
		str1[len - 1] = tmp;
		if (0 == strcmp(str1, str2)){
			return 1;
		}
	}
	return 0;
}
int main(){
	char s1[10] = "AABCD";
	char s2[10] = "BCDAA";
	printf("%d\n", judge(s1, s2));

	system("pause");
	return 0;
}
