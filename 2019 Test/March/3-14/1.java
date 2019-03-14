interface Computer{
	void printComputer();
}
class MacbookProComputer implements Computer{
	public void printComputer(){
		System.out.println("This is MacbookPro");
	}
}
class SurfacBookComputer implements Computer{
	public void printComputer(){
		System.out.println("This is SurfaceBook");
	}
}

interface OperatingSystem{
	void printSystem();
}
class MacOsSystem implements OperatingSystem{
	public void printSystem(){
		System.out.println("This is mac OS");
	}
}
class windowsSystem implements OperatingSystem{
	public void printSystem(){
		System.out.println("tHIS IS WINDOW ");
	}
}
interface ProductionFactory{
	Computer createComputer();
	OperatingSystem createSystem();
}
class AppleFactory implements ProductionFactory{
	public Computer createComputer(){
		return new MacbookProComputer();
	}
	public OperatingSystem createSystem(){
		return new MacOsSystem();
	}
}
class MsFactory implements ProductionFactory{
	public Computer createComputer(){
		return new SurfacBookComputer();
	}
	public OperatingSystem createSystem(){
		return new windowsSystem();
	}
}
public class Test{
	public void buyComputer(Computer computer){
		computer.printComputer();
	}
	public void use(OperatingSystem s){
		s.printSystem();
	}
	public static void main(String[] args){
		Test test = new Test();
		ProductionFactory factory = new AppleFactory();
		Computer computer = factory.createComputer();
		OperatingSystem system = factory.createSystem();
		test.buyComputer(computer);
		test.use(system);
	}
}
