package day_2_27;

public class heapSort {
public void heapsort(int[] array) {
	int length=array.length;
	for(int i=length/2-1;i>=0;i--) {
		adjustMaxHeap(array,i,length);
	}
	for(int i=length-1;i>0;i--) {
		wrap(array,0,i);
		adjustMaxHeap(array, 0, i);
	}
}
	private void wrap(int[] array, int i, int j) {
	// TODO Auto-generated method stub
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
}
	private void adjustMaxHeap(int[] array, int s, int length) {
	// TODO Aint temp=array[s];
		int temp =array[s];
		int child;
		for(child=s*2+1;child<=length-1;child=child*2+1) {
			if(child<length-1&&array[child]<array[child+1]) {
				child++;
			}
			if(array[child]>temp) {
				array[s]=array[child];
				
			}else {
				break;
			}
			
			array[child]=temp;
			s=child;
		}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
