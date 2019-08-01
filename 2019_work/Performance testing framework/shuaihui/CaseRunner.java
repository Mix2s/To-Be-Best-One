package com.shuaihui;



import com.shuaihui.Case;
import com.shuaihui.annotations.BenchMark;
import com.shuaihui.annotations.Measurement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class CaseRunner{
    private static final int DEFAULT_ITERATIONS = 10;
    private static final int DEFAUIL_GROUP = 5;

    private final List<Case> caseList;

    public CaseRunner(List<Case> caseList){
        this.caseList = caseList;
    }
    public void run(){
        for(Case bCase:caseList){
            //找到对象中需要测试的方法
            int iterations = DEFAULT_ITERATIONS;
            int group = DEFAUIL_GROUP;
            //获取类级别的配置
            Measurement classMeasurement = bCase.getClass().getAnnotation(Measurement.class);
            if(classMeasurement!=null){
                iterations = classMeasurement.iterations();
                group = classMeasurement.group();
            }


            Method[] methods = bCase.getClass().getMethods();
            for(Method method:methods){
                BenchMark benchMark = method.getAnnotation(BenchMark.class);
                if(benchMark==null){
                    continue;
                }
                Measurement methodMeasurment = method.getAnnotation(Measurement.class);
                if(methodMeasurment!=null){
                    iterations = methodMeasurment.iterations();
                    group = methodMeasurment.group();
                }
                runCase(bCase,method,iterations,group);
            }
        }
    }

    private void runCase(Case bCase, Method method, int iterations, int group) {
        System.out.println(method.getName());
        for(int i=0;i<group;i++){
            long t1 = System.nanoTime();
            for(int j=0;j<iterations;j++){
                try {
                    method.invoke(bCase);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            long t2 = System.nanoTime();
            System.out.println("第"+i+"次实验时间："+(t2-t1));
        }
    }
}
