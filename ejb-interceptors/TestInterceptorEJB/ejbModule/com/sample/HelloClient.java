package com.sample;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

public class HelloClient
{

    public static void main(String[] args) throws Exception
    {
        InitialContext ctx = getInitialContext();

        Object obj = ctx.lookup("mytest");

        Echo ejbObject = (Echo) obj;
        ejbObject.printMessage("Hello");

    }

    protected static InitialContext getInitialContext() throws NamingException
    {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.NamingContextFactory");
        env.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
        env.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
        //env.put(Context.SECURITY_PRINCIPAL, "admin");
        //env.put(Context.SECURITY_CREDENTIALS, "admin");
        return new InitialContext(env);
    }

}
