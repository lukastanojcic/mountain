package com.example.mountainclimbing.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect2 {
	
	private Logger logger = Logger.getLogger(LoggingAspect2.class.getName());
	
	@Pointcut("within(com.example.mountainclimbing.service.*)")
	public void allMethods() {}
	
	@Around("allMethods()")
	public Object print (ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();
        if(methodArgs.length != 0) {
        	StringBuffer buffer = new StringBuffer();
        	for(int i = 0; i<methodArgs.length;i++) {
        		buffer.append(methodArgs[i]+", ");
        	}
        	logger.severe("Call method " + methodName + " with arg " + buffer);
        }else {
        	logger.severe("Call method " + methodName + " without arg");
        }
        Object result = thisJoinPoint.proceed(); 
        logger.info("Method " + methodName + " returns: " + result);
        return result;
	}
}
