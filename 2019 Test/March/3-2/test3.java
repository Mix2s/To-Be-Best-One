import java.util.Arrays;
public class test2{
	
	public static void processData(int[] temp){
		double[] result = new double[4] ;
		result[0] = temp[0] ; // result[0] means the max of the array
		result[1] = temp[0] ; // result[1] means the min of the array
		result[2] = temp[0] ; // result[2] means the sum of the array
		result[3] = temp[0] ; // result[3] means the avg of tha array
	for (int i =0 ; i < temp.length;i++){
			result[2] += temp[i] ;
		if (temp[i]>result[0]){
			result[0] = temp[i] ;
	}
		if (temp[i]<result[1]){
			result[1] = temp[i] ;
		}
	}
	result[3] = result[2]/temp.length ;
		System.out.println("最大值为:" +result[0]);
		System.out.println("最小值为:"+result[1]);
		System.out.println("总和为："+result[2]);
		System.out.println("平均值为："+result[3]);
}
	public static void main(String[] args){
		
		
	}
	public static void test1(){
		int[] dataA=new int[]{1,12,23,6,12,246,1,346};
		int[] dataB=new int[]{51,15,26,45,1,45,12,567,15,1};
		
		int[] result = Arrays.copyOf(dataA,10);
		printArray(result);
		System.arraycopy(dataB,4,dataA,1,3);
		printArray(dataA);
	}
	public static void printArray(int[] temp){
		for(int i =0;i<temp.length;i++){
			System.out.print(temp[i]+" ");
		}
		System.out.println();
	}
 }
