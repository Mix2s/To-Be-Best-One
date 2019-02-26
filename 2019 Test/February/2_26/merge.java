package day_2_26;
/*
 * 初始将一个数组中每个元素都看成一个有序序列(数组长度为n)，
 * 然后将相邻两个有序序列合并成一个有序序列，
 * 第一趟归并就可以得到n/2个长度为2
 * (最后一个有序序列的长度可能是1，也可能不是，
 * 关键看数组中元素的个数了)的有序序列，
 * 在进行两两归并，得到n/4个长度为4的有序序列
 * (最后一个的长度可能小于4)...
 * 一直这样归并下去，直到得到一个长度为n的有序序列1
 */
public class merge {
//1、解决相邻两个有序序列归并成一个有序序列，
//   非常简单，新增一个数组(长度和需要排列的数组相同)，
	/*
	 * @param r 原数组 需要排序的数组
	 * @param r1 新数组 排序后的数组
	 * @param  s  两个有序排列的数组的一个有序序列第一个元素的下标
	 * @param m 两个有序序列第一个有序序列最后一个元素下标
	 * @param n 两个有虚虚枯额杜尔阁有序序列最后一个元素下标
	 */
	public void merge(int[] r,int[] r1,int s,int m,int t) {
		int i=s;
		int j=m+1;
		int k=s;
		while(i<=m&&j<=t) {
			if(r[i]<r[j]) {
				r1[k++]=r[i++];
			}else {
				r1[k++]=r[j++];
			}
		}
		while(i<=m) {
			r1[k++]=r[i++];
		}
		while(j<=t) {
			r1[k++]=r[j++];
		}
	}
	
	
	/*
	 * @param r 原数组
	 * @param r1 排序后
	 * @param h 序列含有的元素个数
	 * @param n 数组长度
	 */
	public void mergePass(int[] r,int[] r1,int h,int n) {
		int i=0;
		while((i+2*h-1)<=n) {
			merge(r,r1,i,i+h-1,i+2*h-1);
			i+=2*h;
		}
		if(i+h-1<n) {
			merge(r,r1,i,i+h-1,n);
			i+=2*h;
		}else {
			for(;i<=n;i++) {
				r1[i]=r[i];
			}
		}
	}
	
	//完成整个排序
	public void mergeSort(int[] r,int[] r1,int n) {
		int h=1;
		while(h<n) {
			mergePass(r, r1, h, n);
			h=2*h;
			mergePass(r, r1, h, n);
			h=2*h;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {4,3,5,1,7,0};
		int[] array1={};
		merge st = new merge();
		st.mergeSort(array, array1, 6);
		for(int i:array) {
			System.out.println("i"+i);
		}
	}

}
