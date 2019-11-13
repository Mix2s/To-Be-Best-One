package com.starter.springstarterautoconfigurer;

public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String saywudi(String name){
        return helloProperties.getPrefix()+"wudi"+name+helloProperties.getSuffix();
    }
}
