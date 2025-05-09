package com.project.digitalLibrary.zzzz_beans;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Before("execution(* com.project.digitalLibrary.*.*.*(..))")
	public void logMethodCall(JoinPoint jp) {
		log.info("Logging: Calling {} with arguments: {}", jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
	}
}
