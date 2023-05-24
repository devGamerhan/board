package com.example.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class Log4jAdvice {
//	@Pointcut("execution(* com.example..*Impl.*(..))")
//	public void allPointCut() {}
//	
//	@Pointcut("execution(* com.example..*Impl.get*(..))")
//	public void getPointCut() {}
	
	@Before("PointCutCommon.allPointCut()")
	public void printLoggingBefore(JoinPoint jp) {
		String method = jp.getSignature().getName();	//호출한 메소드 이름 리턴
		Object[] args = jp.getArgs();
		System.out.println("[before] "+method+" 메소드 arguments 정보 : "+args[0].toString());
	}
	
	@After("PointCutCommon.getPointCut()")
	public void printLoggingAfter(JoinPoint jp) {
		String method = jp.getSignature().getName();	//호출한 메소드 이름 리턴
		Object[] args = jp.getArgs();
		System.out.println("[after] "+method+" 메소드 arguments 정보 : "+args[0].toString());
	}
}
