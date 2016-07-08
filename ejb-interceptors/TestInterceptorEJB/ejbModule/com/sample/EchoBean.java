package com.sample;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.jboss.ejb3.annotation.AspectDomain;
import org.jboss.ejb3.annotation.RemoteBinding;
import org.jboss.ejb3.interceptor.EJB3InterceptorsInterceptor;

@Stateless
@Remote(Echo.class)
@Interceptors(EchoInterceptor.class)
@RemoteBinding(jndiBinding="mytest")
public class EchoBean implements Echo {

	public String printMessage(String message) {
		
		System.out.println(" Executing method : printMessage : " + message);
		return "Message is " + message;
	}

}