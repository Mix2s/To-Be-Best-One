、、tt
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

interface Factory{
	Car createCar();
}

class BMW4S implements Factory{
	public Car createCar(){
		return new BMW();
	}
}
class AuDi4s implements Factory{
	public Car createCar(){
		return new AuDi();
	}
}
public class Test{
	public void buyCar(Car car){
		car.createCar();				//根据对象打印适合方法
	}
	public static void main(String[] argss){
		Test test = new Test();
		Factory factory = new BMW4S();
		test.buyCar(factory.createCar());
		
	}
}
