package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass
{
	public static void main(String[] args)
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 스프링컨테이너 생성
		
		ctx.load("classpath:beans.xml"); // 설정
		System.out.println("여기는 설정");
		
		ctx.refresh();	// 설정
		// afterPropertiesSet()실행 - Student
		// initMethod() 실행 - OtherStudent
		
		Student student = ctx.getBean("student", Student.class);	// 사용
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		
		System.out.println("나는 빈");  // 빈 역활
		
		OtherStudent otherstudent = ctx.getBean("otherStudent", OtherStudent.class);  // 사용
		System.out.println("이름 : " + otherstudent.getName());
		System.out.println("나이 : " + otherstudent.getAge());
		
		ctx.close();	// 종료
		// 여기는 빈이 소멸된 상태로 아래가 실행됨.
		// destroyMethod() 실행 -OtherStudent
		// destroy() 실행 - Student
		System.out.println("난 스프링컨테이너 밖");
	}
}
