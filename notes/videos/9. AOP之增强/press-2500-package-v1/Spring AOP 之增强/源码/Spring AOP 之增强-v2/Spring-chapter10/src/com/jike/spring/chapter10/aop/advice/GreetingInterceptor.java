package com.jike.spring.chapter10.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		String clientName = (String)args[0];
		System.out.println("GreetingAroundAdvice:How are you！Mr."+clientName+".");
		
		Object obj = invocation.proceed();
		
		System.out.println("GreetingAroundAdvice:Please enjoy yourself!");
		
		return obj;
	}
}
