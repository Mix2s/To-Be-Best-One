public class Test{
    public static void main(String[] args){
        try{
            System.out.println(calculate(10,0));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static  int calculate(int x,int y) throws Exception{
        int result = 0;
        System.out.println("计算开始");
        try{
            result = x/y;
        }catch(Exception e){
            throw e;
        }finally{
            System.out.println("计算结束");
        }
        return result;
    }
    public static void code(){
        System.out.println("1.数字计算");
        try {
            System.out.println("2,进行计算" + 10 / 0);
        }catch (ArithmeticException e){
            System.out.println("处理");
        }
        System.out.println("3.数值计算");
    }
    public static void code1(){
        System.out.println("计算开始");
        try{
           // int x = Integer.parseInt(args[0]);
            // int y = Integer.parseInt(args[1]);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }catch(NumberFormatException e) {
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }finally{
            System.out.println("最后输出");
        }
        System.out.println("计算结束");
    }
}
