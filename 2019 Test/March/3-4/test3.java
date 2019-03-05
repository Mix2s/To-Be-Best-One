public class test{
	// // 
	// public static void main(String[] args) {
        // Confun c = new Confun();
    // }
	
	// static class Confun{
		// Confun(){
			// System.out.println("HHHHH");
		// }
	// }
	
	//有参构造
	// public static void main(String[] args){
        // Person z=new Person(20,"zhangsan");
        // System.out.println(z.getAge()+z.getName());
    // }
// }

// class Person
// {
    // private int age;
    // private String name;
    // public Person(int x,String y){
        // age=x;
        // name=y;
    // }
    // public int getAge(){
        // return age;
    // }
    // public String getName(){
        
        // return name;
    // }
	
	 public static void main(String[] args) {
            PersonDemo s=new PersonDemo("李三",33);        //new对象时，即调用对应的构造函数，并传值。同时，不能new同一个对象多次，否则会报错。
            s.setName("李五");                            //对象建立后，想变更值时，就要用set/get方法，重新设置新的值
            s.setName("阿尔法狗");                        //并可调用对象多次。
            s.print();
    }
	
	class PersonDemo{
    private String name;
    private int age;
    PersonDemo(String n,int m){                //建立有参构造函数，用于给两个private变量name、age赋值，同时输出值
        name=n;
        age=m;
        System.out.println("姓名："+name+"年龄："+age);
    }
	
	  public void setName(String x){            //set方法，用于再次给name赋值
        name=x;        
    }
	
    public String getName(){                //get方法，用于获取name的赋值
        return name;
    }
	
    public void print(){
        System.out.println(name);
    }
}
}

