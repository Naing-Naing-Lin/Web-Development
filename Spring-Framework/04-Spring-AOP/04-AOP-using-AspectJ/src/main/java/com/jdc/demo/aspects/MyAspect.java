package com.jdc.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MyAspect {

	//@Pointcut("bean(myService)")
	@Pointcut("execution(public * com.jdc.demo.service.MyService.*(..))")
	void myServiceBean() {
	}
	
	@Before(value = "myServiceBean() && args(value, count)", argNames = "value, count")
	void doBefore(String value, int count) {
		System.out.println("Before Method ...");
		System.out.println("Value is %s".formatted(value));
		System.out.println("Count is %d".formatted(count));
	}
	
	@After(value = "myServiceBean() && args(*, number)", argNames = "number")
	public void doAfter(int number) {
		System.out.println("After Method ...");
		System.out.println("Number is %d".formatted(number));
	}

	@AfterReturning(pointcut = "myServiceBean()", returning = "result")
	public void doAfterReturning(String result) {
		System.out.println("After Returning Method ...");
		System.out.println("Return value is %s".formatted(result));
	}

	@AfterThrowing("myServiceBean()")
	public void doAfterThrowing() {
		System.out.println("After Throwing ...");
	}

	@Around("myServiceBean()")
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
