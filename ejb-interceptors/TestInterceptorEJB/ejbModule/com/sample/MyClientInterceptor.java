package com.sample;

import java.io.Serializable;

import org.jboss.aop.advice.Interceptor;
import org.jboss.aop.joinpoint.Invocation;
import org.jboss.aop.joinpoint.MethodInvocation;


public class MyClientInterceptor implements Interceptor, Serializable{
    private static final long serialVersionUID = 1L;
    
 
    public String getName() {
        return MyClientInterceptor.class.getSimpleName();
    }
 
    public Object invoke(Invocation invocation) throws Throwable {
       
       String methodName = ((MethodInvocation) invocation).getMethod().getName();
       System.out.println("MyClientInterceptor intercepting method start:" + methodName);
       invocation.getMetaData().addMetaData("mimetadata", "mimetadata", 123);
       Object result = invocation.invokeNext();
       System.out.println("MyClientInterceptor intercepting method end:" + methodName);
        return result;
    }
}
