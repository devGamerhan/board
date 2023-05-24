package com.example.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
//	@Pointcut("execution(* com.example..*Impl.*(..))")
//	public void allPointCut() {}
	
	@AfterThrowing(throwing = "exceptObj", pointcut = "PointCutCommon.allPointCut()")
	public void exceptionLog(JoinPoint jp,Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] "+method+" 메소드 수행 중 발생한 에러 : "+exceptObj.getMessage());
	}
}
