public class test{
	public static void main(String[] args){
		Car car = new Car("卢本伟");
		System.out.println(car);
	}
}
class Car{
	private String name;
	private int price;
	private char sign;
	
	
	public String getName(String name){
		this.name=name;
		return name;
	}
	public String setName(String name){
		this.name=name;
		return name;
	}
	
	public int getPrice(int price){
		this.price=price;
		return price;
	}
	public int setPrice(int price){
		this.name=name;
		return price;
	}
	
	public char getSign(char sign){
		this.sign=sign;
		return sign;
	}
	
	public char setSign(char sign){
		this.sign=sign;
		return sign;
	}
	
	
	public void Car(String name){
		this.name=name;
		this.price=price;
		
	}
	
	public String toString(){
		return "车名"+name+"价格"+price+"sign"+sign;
	}
}
