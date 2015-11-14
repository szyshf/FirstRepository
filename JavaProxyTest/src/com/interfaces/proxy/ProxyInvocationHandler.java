package com.interfaces.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler{

    private Object obj;
    
    public ProxyInvocationHandler(Object obj){
        this.obj = obj;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("ProxyInvocationHandler invoke method satart ,invoke method --> "+method.getName());
        Object ret = method.invoke(obj, args);
        return ret;
    }

}
