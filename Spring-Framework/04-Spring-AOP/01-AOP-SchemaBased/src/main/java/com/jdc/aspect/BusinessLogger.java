package com.jdc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class BusinessLogger {

	public void doBefore(JoinPoint joinPoint) {
		System.out.println("Before Method ...");
		
		System.out.println("Long String -> %s".formatted(joinPoint.toLongString()));
		System.out.println("Short String -> %s".formatted(joinPoint.toShortString()));

		
	}

	public void doAfter() {
		System.out.println("After Method ...");
	}

	public void doAfterReturning() {
		System.out.println("After Returning Method ...");
	}

	public void doAfterThrowing() {
		System.out.println("After Throwing ...");
	}

	public Object doAround(ProceedingJoinPoint joinPoint) {

		Object obj = null;

		try {
			// before
			System.out.println("Before in around");
			obj = joinPoint.proceed();

			// after
			System.out.println("After in around");
		} catch (Throwable e) {
			// after throwing
			System.out.println("After throwing in around");
			throw new RuntimeException(e);
		} finally {
			// after returning
			System.out.println("After Returning in around");
		}

		return obj;
	}
}
