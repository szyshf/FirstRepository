package com.interfaces.impl;

import com.interfaces.IProxyService;

public class ProxyServiceImpl implements IProxyService {

    private String message;
    
    @Override
    public void setMessage(String message) {
        System.out.println(" do in method setMessage()");
        this.message = message;
    }

    @Override
    public String getMessage() {
        System.out.println(" do in method getMessage()");
        return this.message;
    }

}
