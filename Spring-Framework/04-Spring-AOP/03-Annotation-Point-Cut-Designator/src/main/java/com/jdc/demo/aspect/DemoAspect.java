package com.jdc.demo.aspect;

import org.aspectj.lang.JoinPoint;

public class DemoAspect {

	public void beforeExecution(JoinPoint joinPoint) {
		
		var target = joinPoint.getTarget();
		var proxy = joinPoint.getThis();
		var args = joinPoint.getArgs();
		var methodName = joinPoint.getStaticPart().getSignature().getName();
		
		System.out.println("-------------------------");
		System.out.println("Before Method Execution");
		System.out.println("%-10s : %s".formatted("Target", target.getClass().getSimpleName()));
		System.out.println("%-10s : %s".formatted("Proxy", proxy.getClass().getSimpleName()));
		System.out.println("%-10s : %s".formatted("Method Name", methodName));
		System.out.println("-------------------------");
		
		for(int i = 0; i < args.length; i++) {
			var arg = args[i];
			System.out.println("%d. %-10s : %s".formatted(i+1, arg.getClass().getSimpleName(), arg));
		}
		System.out.println("-------------------------");
		
	}
}
