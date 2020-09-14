package com.emina.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger log=Logger.getLogger(getClass().getName());
	@Pointcut("execution(* com.emina.springdemo.controller.*.*(..))")
	private void forController() {}
	
	@Pointcut("execution(* com.emina.springdemo.dao.*.*(..))")
	private void forDAO() {}
	
	@Pointcut("execution(* com.emina.springdemo.service.*.*(..))")
	private void forService() {}
	
	@Pointcut("forController() || forService() || forDAO()")
	private void forEvery() {}
	
	
	@Before("forEvery()")
	public void before(JoinPoint jp) {
		String metoda=jp.getSignature().toShortString();
		log.info("In @Before advice: " +metoda);
	}
	
	
	
}
