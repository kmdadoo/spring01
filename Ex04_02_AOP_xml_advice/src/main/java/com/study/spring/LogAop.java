package com.study.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

// 공통 기능을 수행할 클래스 정의
public class LogAop
{
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable 
	{
		String signatureStr = joinpoint.getSignature().toShortString();
		// 핵심기능 수행전 출력된다.
		System.out.println( signatureStr + " is start.");
		
		// 시스템에서 현재 시간을 밀리세컨즈 단위로 가져온다.
//		long st = System.currentTimeMillis();
		long st = System.nanoTime();
		System.out.println(st);
		try
		{
			// loggerApp의 파라미터로 전달이 되고 실제로 이곳에서 실행이 된다.
			Object obj = joinpoint.proceed();
			return obj;
		} finally 
		{
			// 핵심기능 수행 후 시스템 시간을 가져온다.
//			long et = System.currentTimeMillis();
			long et = System.nanoTime();
			System.out.println(et);
			
			System.out.println( signatureStr + " is finished.");
			// 핵심기능의 수행된 시간을 로그에 출력한다.
			System.out.println( signatureStr + " 경과시간 : " +(et - st));
		}
	}
	
	public void beforeAdvice(JoinPoint joinpoint) {
		System.out.println("beforeAdvice()");
	}
	
	// AOP가 적용될 메소드가 에러없이 성공적으로 실행이 되면 advice 실행
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	
	//  AOP가 적용될 메소드가 에러가 발생하였을때 Exception을 던질때 advice 실행
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}
	
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
}
