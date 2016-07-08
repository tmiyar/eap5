package com.sample;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class EchoInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		
		System.out.println("EchoInterceptor - Logging BEFORE calling method :" + context.getMethod().getName() );

		Object result = context.proceed();
		
		System.out.println("EchoInterceptor  -Logging AFTER calling method :" + context.getMethod().getName() );

		return result;
	}
}
