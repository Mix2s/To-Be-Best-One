package com.cglib;

import com.hui.com.hui.proxy.IProducer;

public class Producer{
    public void saleProduct(float money){
        System.out.println("卖东西 赚钱"+money);
    }
    public void afterService(float money){
        System.out.println("提供服务 赚钱"+money);
    }
}
