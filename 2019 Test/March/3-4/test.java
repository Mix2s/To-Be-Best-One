
public class test{
	
	static class MyObj{
	public int b=99;
}
public void pass(int j){
	j=20;
	System.out.println("print in pass is"+j);
}	
	public static void main(String[] args){
		// test t = new test();
		// int a = 99;
		  // t.test1(a);//这里传递的参数a就是按值传递 
        // System.out.println(a);
         
        // MyObj obj=new MyObj(); 
        // t.test2(obj);//这里传递的参数obj就是引用传递
        // System.out.println(obj.b);
		test t = new test();
		int i=10;
		t.pass(i);
		System.out.println("print in main, i is"+i);
		//print in pass is20
		//print in main, i is10
		
		
	}
	
	public void test1(int a){ 
        a=a++;
        System.out.println(a);
        } 
     
    public void test2(MyObj obj){ 
        obj.b=100;
        System.out.println(obj.b);
        } 
}
