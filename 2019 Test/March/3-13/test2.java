import java.util.Scanner;
interface Computer{
	void printComputer();
}
class MacComputer implements Computer{
	public void printComputer(){
		System.out.println("This is MacComputer");
	}
}
class WinComputer implements Computer{
	public void printComputer(){
		System.out.println("This is WinComputer");
	}
}
interface OperatingSystem{
	void printSystem();
}
class MacSystem implements OperatingSystem{
	public void printSystem() {
		System.out.println("This is a mac os");
	}
}
class WinSystem implements OperatingSystem{
	public void printSystem() {
		System.out.println("This is a window 8");
	}
}
interface ProductionFactory {
		Computer createComputer();
		OperatingSystem createSystem();
	}
class AppleFactory implements ProductionFactory {
		public Computer createComputer() {
		return new MacbookProComputer();
	}
public OperatingSystem createSystem() {
		return new MacOsSystem();
		}	
	}
class MsFactory implements ProductionFactory {
		public Computer createComputer() {
		return new SurfaceBookComputer();
}
public OperatingSystem createSystem() {
		return new Windows8System();
	}
}
class ComputerFactory{
	public static Computer getInstance(String type){
		switch(type){
			case "Mac":
				return new MacComputer();
			case "Win":
				return new WinComputer();
			default:
				return null;
		}
	}
}
public class Test{
	public void buyComputer(Computer computer){
		computer.printComputer();
	}
	public void use(OperatingSystem s) {
		s.printSystem();
	}
	public static void main(String[] args){
		Test test = new Test();
		ProductionFactory fact = new AppleFactory();
		Computer computer = fact.createComputer();
		OperatingSystem system = factory.createSystem();
		test.buyComputer(computer);
		test.use(system);
	}
}
