public class test{
	public static void carry(TalkPower p, String input) { 
	System.out.println("调用对象名：" + p.getClass().getName()); 
	System.out.println(p.talk(input)); 
	}
	public static void main(String[] args) {
        carry(new People(), TestUtils.GMS);
        carry(new Anima(), TestUtils.GMS);
    }
}
interface TalkPower {
    String talk(String input);
}
class People implements TalkPower {

    @Override
    public String talk(String input) {
        return input.toUpperCase();
    }
}
class Anima implements TalkPower {
	@Override
	public String talk(String input) { 
	return Arrays.toString(input.split(" ")); 
	} 
	}
