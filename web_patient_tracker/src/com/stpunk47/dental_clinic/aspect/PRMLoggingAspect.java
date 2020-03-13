package com.stpunk47.dental_clinic.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	//setup pointcut declarations
	@Pointcut("execution(* com.stpunk47.dental_clinic.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//the same for DAO and service
	
	@Pointcut("execution(* com.stpunk47.dental_clinic.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.stpunk47.dental_clinic.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage() ")
	private void forAppFlow() {}
			
	
	//@Before
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//display method
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @Before: calling method: "+theMethod);
			
		//display the arguments
			Object[] args = theJoinPoint.getArgs();

			for(Object tempArg: args) {
				myLogger.info("====> argument: "+ tempArg);
			}
	}
	
	
	
	//@AfterReturning
	
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @AfterReturning: calling method: "+theMethod);
		
		myLogger.info("====> result: "+theResult);
		
	}
 
}
