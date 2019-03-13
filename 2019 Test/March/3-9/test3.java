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
	public static void main(String[] args){
		Test test = new Test();
		Scanner scanner = new Scanner(System.in);
		System.out.println("wudi8");
		String type = scanner.next();
		Computer computer = ComputerFactory.getInstance(type);
		test.buyComputer(computer);
	}
}
