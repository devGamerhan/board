package com.example.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutCommon {
	@Pointcut("execution(* com.example..*Impl.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* com.example..*Impl.get*(..))")
	public void getPointCut() {}
}
