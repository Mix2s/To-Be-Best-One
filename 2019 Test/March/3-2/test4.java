	class Person {
		private String name ;
		private int age ;
	public Person(String name, int age) {
		this.name = name ;
		this.age = age ;
	public void getInfo() {
		System.out.println("姓名："+this.name+",年龄："+this.age) ;
			}
	}
	public class test2 {
		public static test1(){
					Person[] per = new Person[3] ; // 数组动态初始化，每个元素都是其对应数据类型的默认值
			per[0] = new Person("张三",1) ;
			per[1] = new Person("李四",2) ;
			per[2] = new Person("王五",3) ;
	for (int x = 0 ; x < per.length ; x++) {
			per[x].getInfo() ;
			}
			}
		}
	public static void main(String[] args){
		Person[] per = new Person[] {
		new Person("张三",1) ,
		new Person("李四",2) ,
		new Person("王五",3)
		} ; 
	for (int x = 0 ; x < per.length ; x++) {
	per[x].getInfo() ;
		}
	}
