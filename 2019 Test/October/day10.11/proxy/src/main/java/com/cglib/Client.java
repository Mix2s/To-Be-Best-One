package com.cglib;

import com.hui.com.hui.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Producer aa = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
           /*
                执行被代理方法 都会经过该方法
            */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object obj = null;
                //提供增强代码
                Float money = (Float) args[0];
                if("saleProduct".equals(method.getName())){
                    obj = method.invoke(producer,money*0.8f);
                }
                return obj;
            }
        });
        aa.saleProduct(100f);
    }
}
