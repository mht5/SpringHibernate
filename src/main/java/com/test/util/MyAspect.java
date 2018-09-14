package com.test.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* com.test.service.*.*(..))")
	public void myPointCut() {
		
	}

	@Before(value="myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("before: " + joinPoint.getSignature().getName());
	}
	
	/**
	 * retΪpointCut�����ķ���ֵ
	 * @param joinPoint
	 * @param ret
	 */
	@AfterReturning(value="myPointCut()", returning="ret")
	public void myAfterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("after returning: " + joinPoint.getSignature().getName() + "-->" + ret);
	}

	@After(value="myPointCut()")
	public void myAfter() {
		System.out.println("after");
	}

	@AfterThrowing(value="myPointCut()", throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("after throwing: " + e.getMessage());
	}

	/**
	 * ʹ��ע���around����beforeǰ���룬ʹ��xml���õ�around����before֮��
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around(value="myPointCut()")
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("before...");
		Object obj = joinPoint.proceed();
		System.out.println("after...");
		return obj;
	}
	
}
