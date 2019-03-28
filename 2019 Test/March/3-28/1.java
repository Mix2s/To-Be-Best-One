public class Test {
    public static void main(String[] args) {

    }
    public static void code2(){
//        UserService userSercvice = MyBeanFactory.createUserservice();
//        userSercvice.addUser();
//        userSercvice.unpdateUser();
//        userSercvice.deleteUser();;
//        interface UserService{
//            public void addUser();
//            public void unpdateUser();
//            public void deleteUser();
//        }
//        class UserServiceImpl implements UserService {
//            public void addUser() {
//                System.out.println("添加");
//            }
//
//            @Override
//            public void unpdateUser() {
//                System.out.println("更新");
//            }
//
//            @Override
//            public void deleteUser() {
//                System.out.println("删除");
//            }
//        }
//        class MyBeanFactory{
//            public static UserService createUserservice(){
//                final UserService userService = new UserServiceImpl();
//                UserService proxyService = (UserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(),
//                        userService.getClass().getInterfaces(),
//                        new InvocationHandler(){
//                            public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
//                                Object obj = method.invoke(userService,args);
//                                return obj;
//                            }
//                        });
//                return proxyService;
//            }
//        }
    }
   public static void code1(){
//        interface ISinger{
//            void sing();
//        }
//        class Singer implements ISinger{
//            public void sing(){
//                System.out.println("标记位");
//            }
//        }
//        class SingerProxy implements ISinger{
//            private ISinger target;
//            public SingerProxy(ISinger target){
//                this.target = target;
//            }
//            public void sing(){
//                System.out.println("代理类实现对象");
//                target.sing();
//            }
//        }
//        Singer target = new Singer();
//        ISinger proxy  = (ISinger) Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("向观众问好");
//                        //执行目标对象方法
//                        Object returnValue = method.invoke(target, args);
//                        System.out.println("谢谢大家");
//                        return returnValue;
//                    }
//                });
//        proxy.sing();
   }
    public static void code(){
//     interface ISinger{
//            void sing();
//        }
//        class Singer implements  ISinger{
//            public void sing(){
//                System.out.println("唱一首歌");
//            }
//        }
//        class SingerProxy implements ISinger{
//            private ISinger target;
//            public SingerProxy(ISinger target){
//                this.target = target;
//            }
//            public void sing(){
//                System.out.println("代理类实现对象");
//                target.sing();
//            }
//        }
    }
}
