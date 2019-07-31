package proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @Pointcut("execution(* add*(..)) || execution(* del*(..))")
    private void allMethod(){

    }
    @Before("allMethod()")
    public void checkSecurity(){
        System.out.println("xxxxxxxcheckSecurit()xxxxxx");
    }


}
