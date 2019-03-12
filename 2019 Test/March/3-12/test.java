public class Test{
	public static void main(String[] args){
		//缓存成功
		Integer a1 =100;
		Integer a2 = 100;
		if(a1==a2){
			System.out.println("a1==a2:"+(a1==a2));
		}
		//缓存失败
		Integer a3 =200;
		Integer a4 = 200;
		if(a1==a2){
			System.out.println("a3==a4:"+(a3==a4));
		}
	}
public static void code1(){
		// Integer a = 1;
        // Integer b = 2;
        // Integer c = 3;
        // Integer d = 3;
        // Integer e = 321;
        // Integer f = 321;
        // Long g = 3L;
        // Long h = 2L;
         
        // System.out.println(c==d);  //true
        // System.out.println(e==f);	//false
        // System.out.println(c==(a+b));	//true
        // System.out.println(c.equals(a+b));	//true
        // System.out.println(g==(a+b));	//true
        // System.out.println(g.equals(a+b));	//false
        // System.out.println(g.equals(a+h));	//true
		// Integer i1 = 100;
        // Integer i2 = 100;
        // Integer i3 = 200;
        // Integer i4 = 200;
		
		// System.out.println(i1==i2);  //true   
        // System.out.println(i3==i4);		//false
		// //int 类型 -128--127 超过127 指向的对象不同
		
		// Double d1 = 100.0;
        // Double d2 = 100.0;
        // Double d3 = 200.0;
        // Double d4 = 200.0;
		// System.out.println(d1==d2);  //false
        // System.out.println(d3==d4);	//false
		// //double 范围大 所以指向的对象不同
		
		// Boolean b1 = false;
        // Boolean b2 = false;
        // Boolean b3 = true;
        // Boolean b4 = true;
		// System.out.println(b1==b2);  //true
        // System.out.println(b3==b4);	 //true
		// //boolean 源码 static final 类型
}
public static void code(){
	// class Shape{
	// public void draw(){
		// System.out.println("Shape draw");
	// }
	// public void erase(){
		
	// }
// }
// class Circle extends Shape{
	// public void draw(){
		// System.out.println("Shape draw");
	// }
	// public void erase(){
		
	// }
// }
// public Squre extends Shape{
	// public void draw(){
		// System.out.println("Squre draw");
	// }
// }
}
}
