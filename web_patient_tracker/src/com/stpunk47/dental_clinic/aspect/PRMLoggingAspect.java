package com.stpunk47.dental_clinic.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	//setup pointcut declarations
	@Pointcut("execution(* com.stpunk47.dental_clinic.controller.*.*.(..))")
	private void forControllerPackage() {}
	
	//the same for DAO and service
	
	@Pointcut("execution(* com.stpunk47.dental_clinic.service.*.*.(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.stpunk47.dental_clinic.dao.*.*.(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage() ")
	private void forAppFlow() {}
	
	
	
	
	
	//@Before
	
	//@AfterReturning

}
