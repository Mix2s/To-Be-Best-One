public class test2{
	public static void printArray(int[] temp){
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
	}
	public static void bigger(int[] arr){
		for(int i=0;i<arr.length;i++){
			arr[i]*=5;
		}
	}
	public static int[] init(){
		return new int[]{1,2,3};
	}
	public static void a3(){
	int[] wudi=new int[]{1,2};
		System.out.println(wudi.length);
		int[][] date = new int[][]{{1,2,3},{4,5},{1}};
		for(int i=0;i<date.length;i++){
		for(int y=0;y<date[i].length;y++){
			System.out.println("date["+i+"]"+"["+y+"]");
			}
		}
	}
	public static void a2(){
		int[] x = new int[]{1,2,3};
		int[] y = x;
		y[0]=5;
		System.out.println(x[0]);
	}
	public static void a1(){
		int[] x = new int[]{10,20,30};
		for(int i =0;i<x.length;i++){
			System.out.println(x[i]);
		}
	}
	public static void mult(){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.println(i+"*"+j+"="+(i*j)+" ");
			}
			System.out.println();
		}
	}
	public static int recu(int num){
		if(num==1){
			return 1;
		}else{
			return num*recu(num-1);
		}
	}
	public static void main(String[] args){
		
		int[] data = init();
		bigger(data);
		printArray(data);
		
	}
}
