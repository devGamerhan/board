package com.example.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.example.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
//	@Pointcut("execution(* com.example..*Impl.get*(..))")
//	public void getPointCut() {}
	
	@AfterReturning(pointcut = "PointCutCommon.getPointCut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName()+" 로그인(admin)");
			}
		}
		
		System.out.println("[after returning] "+method+" 메소드, 리턴 값 : "+returnObj.toString());
		
	}
}
