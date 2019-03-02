import java.util.Arrays;
public class test1{
	
	public static void printArray(int[] temp) {
		for (int i = 0 ; i<temp.length ; i++) {
			System.out.println(temp[i]) ;
		}
		System.out.println() ;
	}
	public static void printArray(char[] temp){
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
		System.out.println();
	} 
	public static void test1(){
		int[] orginal = new int[]{1,3,5,6,6};
		int[] result = Arrays.copyOf(orginal,10);
		for(int temp:result){
			System.out.println(temp);
		}
	}
	public static void test(){
		//类库自含方法java.util.Arrays.sort(arrayName);
		int[] array = new int[]{1,4,22,5,6,8,9,0};
		int max = array[0];
		int min=array[0];
		int sum=0;
		int avg=0;
		for(int i=0;i<array.length;i++){
			sum+=array[i];
			if(max<array[i]){
				max=array[i];
			}
			if(min>array[i]){
				min=array[i];
			}
		}
		System.out.println("max="+max+" "+"min="+min+" "+"avg="+(sum/8)+" "+"sum="+sum);
	}
	public static void main(String[] args){
		int[] inData = new int[]{1,23,15,123};
		char[] charData = new char[]{'z','a','a'};
		java.util.Arrays.sort(inData);
		java.util.Arrays.sort(charData);
		printArray(inData);
		printArray(charData);
	}
}
