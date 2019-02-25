
//public class Full_Permutation {
//	private static void Method1() {
//	disorder(array,0,array.length);
//	}
//	private static void disorder(int array[],int m,int n) {
//		if(m==n) {
//			for(int i=0;i<n;i++) {
//				System.out.println(array[i]);
//			}
//			System.out.println();
//			return;
//		}else {
//			for(int i=m;i<n;i++) {
//				swap(array,m,i);
//				disorder(array, m+1, n);
//				swap(array,m,i);
//			}
//		}
//	}
//	private static void swap(int[] array,int m,int n) {
//		int temp=array[m];
//		array[m]=array[n];
//		array[n]=temp;
//	}



package day_2_24;
/*
 *     A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
    下图就是一种排法
        A
       9 6
      4   8
     3 7 5 2
     这样的排法可能会有很多。
     如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？
     请你计算并提交该数字。
 */
public class Full_Permutation {
static int[] first = new int[9];
static int[] s = new int[9];

private static void Method() {
	seek(0);
	System.out.println(sum/6);
}

private static void seel(int code) {
	if(code==9) {
		if(s[0] + s[1] + s[3] + s[5] == s[0] + s[2] + s[4] + s[8]
                && s[0] + s[1] + s[3] + s[5] == s[5] + s[6] + s[7] + s[8]) {
			sum++;
		}
		return ;
	}
	for(int i=0;i<9;i++) {
		if(first[i]==0) {
			first[i]=1;
			s[code]=9+1;
			seel(code+1);
			first[i]=0;
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
