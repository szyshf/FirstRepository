package com.interfaces.proxy;

import java.lang.reflect.Proxy;

import com.interfaces.IProxyService;
import com.interfaces.impl.ProxyServiceImpl;

public class ProxyMainTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
       ProxyServiceImpl s = new ProxyServiceImpl();
       IProxyService service = (IProxyService) Proxy.newProxyInstance(
               Thread.currentThread().getContextClassLoader(),
               s.getClass().getInterfaces(), 
               new ProxyInvocationHandler(s));
      service.setMessage("message");
      System.out.println(service.getMessage());
    }

}
