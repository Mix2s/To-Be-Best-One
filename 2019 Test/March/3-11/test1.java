interface Inner{
	int getNumber();
}
public Outer{
	public Inner getInnerClass(final int num,String str2){
		return new Inner(){
			int number = num+3;
			public int getNumber(){
				return number;
			}
		};
	}
public static void main(String[] args) {
		Outer out = new Outer();
		Inner inner = =out.getInnerClass(2,"wudi");
		System.out.println(inner.getNumber());
    }
public static void code3(){
	 // Parcel5 parcel5 = new Parcel5();
        // Destionation d = Outer.destionation("wudi");
	// public Outer{
	// public Destionation destionation(String str){
		 // class PDestionation implements Destionation{
			  // private String label;
			  // private PDestionation(String whereTo){
				  // label = whereTo;
            // } 
			 // public String readLabel(){
                // return label;
            // }
			 // }
        // return new PDestionation(str);
    // }
// }
}
public static void code2(){
	// Outer outer = new Outer();
		// Outer.Inner inner = outer.getInnerClass();
		// inner.innerDisplay();
	// public class Outer{
	// private String str;
	// public void outerDisplay(){
		// System.out.println("outerClass...");
	// }
	// public class Inner{
		// public void innerDisplay(){
			// str="wudi";
			// System.out.println("str");
			// outerDisplay();
		// }
	// }
	// public Inner getInnerClass(){
		// return new Inner();
	// }
}
public static void code1(){
	// System.out.println("----------------------");
        // new Test();
        // System.out.println("----------------------");
        // new Test("1");
	// /**
     // * 静态代码块
     // */
    // static{
        // System.out.println("执行静态代码块...");
    // }
    
    // /**
     // * 构造代码块
     // */
    // {
        // System.out.println("执行构造代码块...");
    // }
    
    // /**
     // * 无参构造函数
     // */
    // public Test(){
        // System.out.println("执行无参构造函数...");
    // }
    
    // /**
     // * 有参构造函数
     // * @param id
     // */
    // public Test(String id){
        // System.out.println("执行有参构造函数...");
    // }
}
public static void code(){
	   // new Test();
        // System.out.println("----------------");
        // new Test("1");
	  // /**
     // * 无参构造函数
     // */
    // public Test(){
        // System.out.println("执行构造代码块...");
        // System.out.println("执行无参构造函数...");
    // }
    
    // /**
     // * 有参构造函数
     // * @param id  id
     // */
    // public Test(String id){
        // System.out.println("执行构造代码块...");
        // System.out.println("执行有参构造函数...");
    // }
}
}
