package com.study.spring;

import org.aspectj.lang.ProceedingJoinPoint;

// 공통 기능을 수행할 클래스 정의
public class LogAop
{
	// beans.xml에 등록된 표현식에 의해 Student 클래스와 Worker 클래스가 조인포인트로
	// 설정 되었기때문에 해당클래스의 모든 메서드는 포인트컷이 되었음.
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable 
	{
		/*
		  	현재 호출된 메서드명을 문자열로 변환 후 반환해준다. 즉 실행되는
		  	메서드명을 알 수 있다.
		 */
		String signatureStr = joinpoint.getSignature().toShortString();
		// advice를 around로 지정시 공통기능 수행부분
		// 핵심기능 수행전 출력된다.
		System.out.println( signatureStr + " is start.");
		
		// 시스템에서 현재 시간을 밀리세컨즈 단위로 가져온다.
//		long st = System.currentTimeMillis();
		// JDK1.5부터 추가된 메서드입니다. 이 메서드는 현재 시간(시스템 시간)과 관계가 없습니다
		// 작동중인 JVM의 정밀한 시간 소스의 현재 값을 long타입으로 나노세컨드(1/1000000000초)를 반환합니다.
		// 개발한 프로그램의 성능 측정을 위해 나노초로 정밀하게 구간 시간 측정을 위해서 사용
		//  다른 서버 간 통신 시간 측정 시에는 System.nanoTime()를 사용하면 안 됩니다.
		long st = System.nanoTime();
		System.out.println(st);
		try
		{
			/*
				매개변수를 통해서 핵심기능을 수행한다. proceed()메서드 호출을 통해
				수행 할 수 있고, 이와같이 핵심기능을 수행하는 것을 proxy라고 한다.
			*/
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
}
