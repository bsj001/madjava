package org.example.dynaProxy;

public class Test {
    public static void main(String[] args) throws Exception {
        GunDog target = new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
