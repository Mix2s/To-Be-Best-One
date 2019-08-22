package com.ming.demo_01.po;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: xiao ming
 * @create:2019-08-2019/8/22 10:48
 */
@PropertySource(value={"classpath:orders.properties"})
@Component
@ConfigurationProperties(prefix = "orders")
public class Orders {

    private int orderId;

    private String orderName;

    public Orders(){

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
