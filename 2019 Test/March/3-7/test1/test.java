class A{
	private String name = "A的私有欲";
	public String getName(){
		return name;
	}
}
class B{
	private int age =20;
	public int getAge(){
		return age;
	}
}
class Outer{
	private class InnerClassA extends A{  //内部类
		public String name(){
			return super.getName();
		}
	}
	private class InnerClassB extends B{	//内部类
		public int age(){
			return super.getAge();
		}
	}
	public String name(){
		return new InnerClassA().name();
	}
	public int age(){
		return new InnerClassB().age();
	}
}
/*
class Inner{
	private Outer out;
	public Inner(Outer out){
		this.out = out;
	}
	public void print(){
		System.out.println(out.getMsg());
	}
}*/
public class test{
	public static void main(String[] args){
		// Outer out = new Outer();
		// out.fun();
		Outer outter  = new Outer();
		System.out.println(outter.name());
		System.out.println(outter.age());
	}
	/*
	public static void code1(){
			private String msg = "Hello World" ;
public String getMsg(){ //通过此方法才能取得msg属性
return this.msg ;
}
public void fun(){ //3.现在由out对象调用了fun()方法
Inner in = new Inner(this); //4.this表示当前对象
in.print(); //7.调用方法
}
	}
	public static void code(){
	
		private String msg = "Hello word";
	class Inner{
		public void print(){
			System.out.println(msg);
		}
	}
	public void fun(){
		Inner in = new Inner();
		in.print();
	}
	}
	*/
}
