package day_2_27;
/*
 * 选取一个轴值(比较的基准)，
 * 将待排序记录分为独立的两个部分，
 * 左侧记录都是小于或等于轴值，
 * 右侧记录都是大于或等于轴值，
 * 然后分别对左侧部分和右侧部分重复前面的过程，
 * 也就是左侧部分又选择一个轴值，又分为两个独立的部分，
 * 这就使用了递归了。到最后，整个序列就变得有序了
 */
public class Partition {
public int partition(int[] array,int first,int end) {
	int i=first;
	int j=end;
	while(i<j) {
		while(i<j&&array[i]<array[j]) {
			j--;
		}
		if(i<j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
		i++;
		}
		while(i<j&&array[i]<array[j]) {
			i++;
		}
		if(i<j) {
			int temp=array[i];
			array[i]=array[j];
			array[j]=temp;
			j--;
		}
	}
	return j;
}

public void quickSort(int[] array,int first,int end) {
	if(first<end) {
		int pivot=partition(array, first, end);
		quickSort(array,first,pivot-1);
		quickSort(array,pivot,end);
	}
}

//希尔排序
public void shellSort(int[] array) {
	int i,j,temp;
	int length=array.length;
	int gap=length;
	do {
		gap=gap/2;
		for(i=gap;i<length;i++) {
			if(array[i]<array[i-gap]) {
				temp=array[i];
				for(j=i-gap;j>=0&&array[j]>temp;j-=gap) {
					array[j+gap]=temp;
				}
				array[j+gap]=temp;
			}
		}
	}while(gap>0);
}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,3,4,6,1,7,9};
		Partition qs = new Partition();
		qs.shellSort(array);
		for(int i:array) {
			System.out.println(i);
		}
	}

}
