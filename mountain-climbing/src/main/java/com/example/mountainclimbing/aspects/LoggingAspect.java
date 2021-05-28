package com.example.mountainclimbing.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Pointcut("within(com.example.mountainclimbing.service.*)")
	public void allAlbumMethods() {}
	
	@Before("allAlbumMethods()")
	public void loggingBeforeMethods(JoinPoint joinPoint) {
		logger.info(joinPoint.getSignature().getDeclaringType().toString()+"."+joinPoint.getSignature().getName()+" will be called");
	}
	
	@After("allAlbumMethods()")
	public void loggingAfterMethods(JoinPoint joinPoint) {
		logger.info(joinPoint.getSignature().getDeclaringType().toString()+"."+joinPoint.getSignature().getName()+" method had been called");
	}
}
