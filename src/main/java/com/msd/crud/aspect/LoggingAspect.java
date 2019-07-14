package com.msd.crud.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.msd.crud.domain.User;
import com.msd.crud.domain.UserInfo;


@Aspect
@Component
public class LoggingAspect {

	public final static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before(value = "execution(* com.msd.crud.services.UserService.*(..)) ")
	public void printBasicLog() {
			System.out.println("Printing Basic Advice...");
	}
	
	@AfterReturning(pointcut = "@annotation(com.msd.crud.aspect.Loggable)",returning ="returningObj")
	public void print(UserInfo returningObj) {
		logger.info("Printing Loggable advice :"+returningObj.getUser().getFirstName());
	}
	
}
