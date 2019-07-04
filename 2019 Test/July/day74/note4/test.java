package bite.note4;

import java.util.Properties;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        Properties pro = new Properties();
        pro.setProperty("wudi","jh");
        pro.setProperty("帅辉","aa");
        System.out.println(pro.getProperty("zz"));


    }

}
