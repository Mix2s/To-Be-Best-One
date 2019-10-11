package com.hui.com.hui.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        IProducer aa = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       Object obj = null;
                        //提供增强代码
                        Float money = (Float) args[0];
                        if("saleProduct".equals(method.getName())){
                            obj = method.invoke(producer,money*0.8f);
                        }
                        return obj;
                    }
                }
        );
        aa.saleProduct(100f);
    }
}
