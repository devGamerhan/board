package com.example.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service
@Aspect
public class AroundAdvice {
	
//	@Pointcut("execution(* com.example..*Impl.*(..))")
//	public void a() {}
	
	@Around("PointCutCommon.allPointCut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Object returnObj = pjp.proceed();
		stopWatch.stop();

		System.out.println(".......... "+method+" 메소드 수행에 걸린 시간 : "+stopWatch.getTotalTimeMillis()+"(ms)");
		
		return returnObj; 
	}
}
