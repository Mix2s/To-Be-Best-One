//Java数组章节练习题
import java.util.Arrays;
public class ArrayUtils{

    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
		 int max = data[0];
		 for(int i=1;i<=data.length-1;i++){
			 if(max<data[i]){
				 max=data[i];
			 }
		 }
       return max;
    }
    
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
        int min = data[0];
		 for(int i=1;i<=data.length-1;i++){
			 if(min>data[i]){
				 min=data[i];
			 }
		 }
       return min;
    }
    
    
    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        //TODO
		int sum=0;
		for(int i=0;i<=data.length-1;i++){
			sum+=data[i];
		}
        return sum;
    }
    
    //4.数组拼接
    public static void arrayJoin(int[] a, int[] b){
		int key=a.length;   //先拿到a长度
      a=Arrays.copyOf(a,(a.length+b.length));
	  for(int i=0;i<b.length;i++){
		  a[key+i]=b[i];
	  }
	   for(int i:a){
		   System.out.println(i);
	   }
	}
	   

    //5.数组截取
    //[start, end)
    public static void arraySub(int[] data, int start , int end){
        int key = data.length;
		int[] tool = new int[key];
		System.arraycopy(data,start,tool,0,end-start);
		for(int i=0;i<end-start;i++){
			System.out.println(tool[i]);
		}
    }
    
    //6.数组打印  4,3,2,1
    public static void printArray(int[] data){
        for(int i : data){
			System.out.println(i);
		}
    }
    
    //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
		
        int key = data.length-1;
		int[] tool = new int[key+1];
		for(int i=0;i<=key;i++){
			tool[i]=data[key-i];
		}
		printArray(tool);
    }
    
    public static void main(String[] args){
        //TODO 测试      
		int[] test1 = new int[]{1,2,5,67,1};
		int[] test2 = new int[]{12,125,1};
		int[] test3 = new int[]{1,2,3,4};
		printReversal(test3);
		
    }
}
