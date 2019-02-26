package day_2_26;
/*
 * 先将第一个位值上的数跟之后所有位置上的数依次进行比较，
 * 如果第一个位置上的数比第二个位置上的数大，
 * 则进行互换，然后继续将第一个位置上的数与
 * 第三个位置上的数进行比较，经过一轮的比较后，
 * 第一个位值上的数就是所有数中最小的一个，
 * 接着将第二个位置上的数与之后所有位置上的数进行比较，
 * 同样的规则，第二轮比较结束后，
 * 第二位放的就是所有数中第二小的数，依次往下比，
 * 直到最后一个位置结束。按照这种方法进行排序，就叫做选择排序。
 */
public class InsertSort {
public void insertSort(int[] array) {
	int j,temp;
	for(int i=1;i<array.length;i++) {
		if(array[i]<array[i-1]) {
			temp=array[i];
			for(j=i-1;j>=0&&array[j]>temp;j--) {
				array[j+1]=array[j];
			}
			array[j+1]=temp;
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {4,3,5,1,7,0};
		InsertSort st = new InsertSort();
		st.insertSort(array);
		for(int i:array) {
			System.out.println("i"+i);
		}
	}

}
