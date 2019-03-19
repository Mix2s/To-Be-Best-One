import java.util.Scanner;

interface Car{
	void printCar();          //汽车总接口 汽车这一类
}
class BMW implements Car{          //BMW
	public void printCar(){
		System.out.println("这是一个BMW");
	}
}
class AuDi implements Car{			//AuDi
	public void printCar(){
		System.out.println("这是一个AuDi");
	}
}

interface PortCar{				//进口汽车接口
	void printMation();
}
class ChinaCar implements PortCar{			//国产类
	public void printMation(){
		System.out.println("国产汽车");
	}
}	
class USACar implements PortCar{		//进口汽车
	public void printMation(){
		System.out.println("美国进口汽车");
	}
}

interface Factory{						//工厂
	Car createCar();
	PortCar printMation();
}
class BMWFactory implements Factory{		//包装国产宝马
	public Car createCar(){
		return new BMW();
	}
	public PortCar printMation(){
		return new ChinaCar();
	}
}
class AuDiFactory implements Factory{		//包装进口奥迪
	public Car createCar(){
		return new AuDi();
	}
	public PortCar printMation(){
		return new USACar();
	}
}

public class Test{
	public void buyCar(Car car){
		car.printCar();				//根据对象打印适合方法
	}
	public void buyGrade(PortCar port){
		port.printMation();
	}
	public static void main(String[] argss){
		Test test = new Test();
		Factory fact = new BMWFactory();
		Car car = fact.createCar();
		PortCar port = fact.printMation();
		test.buyCar(car);
		test.buyGrade(port);
		
	}
}
