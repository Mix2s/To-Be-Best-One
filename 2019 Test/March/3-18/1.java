import java.util.Scanner;
interface Car{
	void createCar();          //汽车总接口 汽车这一类
}

class BMW implements Car{          //BMW
	public void createCar(){
		System.out.println("生产一个BMW");
	}
}
class AuDi implements Car{			//AuDi
	public void createCar(){
		System.out.println("生产一个AuDi");
	}
}
class Factory{						//汽车工厂方法  作用选择性的生产 汽车对象
	public static Car getNewCar(String type){
		if(type.equals("BMW")){
			return new BMW();			
		}else if(type.equals("AuDo")){
			return new AuDi();
		}
		return null;
	}
} 

public class Test{
	public void buyCar(Car car){
		car.createCar();				//根据对象打印适合方法
	}
	public static void main(String[] args){
		Test test = new Test();
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入想买的车");
		String type = scanner.next();
		Car car = Factory.getNewCar(type);
		test.buyCar(car);
	}
}
