package com.emina.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	Logger logger=Logger.getLogger(getClass().getName());
	
	
	@Pointcut("execution(* com.emina.springdemo.controller.*.*(..))")
	public void forController() {}
	
	@Pointcut("execution(* com.emina.springdemo.dao.*.*(..))")
	public void forDAO() {}
	
	@Pointcut("execution(* com.emina.springdemo.service.*.*(..))")
	public void forService() {}
	
	@Pointcut("forController() || forDAO() || forService()")
	public void forFull() {}
	
	@Before("forFull()")
	public void before(JoinPoint jp) {
		String metoda=jp.getSignature().toShortString();
		logger.info("==>in @Before calling method: "+metoda);
		
		Object[] args=jp.getArgs();
		
		for(Object t:args) {
			logger.info("Arg: "+t);
		}
	}
	
	@AfterReturning(pointcut="forFull()", returning="result")
	public void after(JoinPoint jp,Object result) {
		String metoda=jp.getSignature().toShortString();
		logger.info("==>in @AfterReturning calling method: "+metoda);
		
		logger.info("Result:"+result);
	}
	
	
}
