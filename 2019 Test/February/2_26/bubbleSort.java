package day_2_26;
/*
 * 冒泡排序跟选择排序一样的简单，
 * 好理解，整个过程就想气泡一样往上升，
 * 假设从小到大排序，对于给定的n个记录，
 * 从第一个记录开始依次对相邻的两个记录进行比较，
 * 当前面的记录大于后面的记录时，交换位置，
 * 进行一轮比较后，第n位上就是整个记录中最大的数，
 * 然后在对前n-1个记录进行第二轮比较，
 * 重复该过程直到进行比较的记录只剩下一个为止。
 */
public class bubbleSort {
public void bubblesort(int[] array) {
	int j=array.length-1;
	while(j>=1) {
		for(int i=0;i<j;i++) {
			if(array[i]>array[i+1]) {
				int t=array[i];
				array[i]=array[i+1];
				array[i+1]=t;
			}
		}
		j--;
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {4,3,5,1,7,0};
		bubbleSort st = new bubbleSort();
		st.bubblesort(array);
		for(int i:array) {
			System.out.println("i"+i);
		}
	}

}
