package main;

public class SycnTest {
    class Super{
        int flag = 1;
        Super(){
            test();
        }
        void test(){
            System.out.println("ss"+flag);
        }
    }
    class Sub extends Super{
        Sub(int i){
            flag = i;
            System.out.println("s1"+flag);
        }
        void test(){
            System.out.println("s2"+flag);
        }
    }

    public static void main(String[] args) {
        int count = 0;
        count = ++count;
        System.out.println(count);
    }
}
