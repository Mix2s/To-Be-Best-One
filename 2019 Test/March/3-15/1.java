class Person{
	private String name;
	private int age;
	public void setName(String name){
		name = name;
	}
	public String getNmae(){
		return name;
	}	
	public void print_this(){
		System.out.println("Person 不在类中创建对象调用this 打印当前对象");
		this.print2();
		}
	public static void print1(){
		System.out.println("Person statc print 打印当前对象"+this);
	}
	public void print2(){
		System.out.println("测试");
	}
	
}
	public class Test{
		public void print(){
		System.out.println("Test print 打印当前对象"+this);
		}
		
		public Test getObj(){
			return new Test();
		}
		public void print_test(){
			t.print_this();
		}
		public void print_this(){
			System.out.println("Test 不使用this 调用 测试");
		}
		public static void main(String[] atgs){
		System.out.println("Person this 测试 p1");
		Person p1 = new Person();
		p1.print();
		System.out.println("Person this 测试 p2");
		Person p2 = new Person();
		p2.print(); 
		System.out.println("Test this 测试 t1");
		Test t1 = new Test();
		t1.print();
		System.out.println("Test this 测试 t1");
		Test t2 = new Test();
		t2.print(); 
		
		Person p = new Person();
		p.print_this();
		// Test test = new Test();
		// test.print_test();
		p.setName("wudi");
		System.out.println(p.getNmae());
	}
}
