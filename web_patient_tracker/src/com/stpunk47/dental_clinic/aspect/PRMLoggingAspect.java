package com.stpunk47.dental_clinic.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	//setup pointcut declarations
	
	//@Before
	
	//@AfterReturning

}
