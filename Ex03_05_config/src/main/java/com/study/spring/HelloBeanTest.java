package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest
{
	public static void main(String[] args)
	{
//		String configLocation = "classpath:beans.xml";
		// 1. 스프링 설정이 클래스패스 루트가 아닌 다른곳에 위치한다.  
		// 	  루트를 기준으로 경로 형식을 입력. beans2를 부르는 방법 둘다 같음.
//		String configLocation1 = "classpath:config/beans2.xml";
//		String configLocation1 = "classpath:/config/beans2.xml";

		// 2. 클래스패스가 아닌 파일 시스템에서 설정 파일을 읽어 오기.
		// 실제 파일이 설치되어 있는 위치
//		String configLocation1 = "file:src/main/resources/config/beans2.xml";	// 절대경로
		
		// 3. 특정 경로에 있는 xml 파일을 설정 파일로 사용하고 싶은 경우
//		String configLocation1 = "classpath:config/beans*.xml";
		
		// A. IoC 컨테이너 생성  
//		ApplicationContext context = 
//				new GenericXmlApplicationContext(configLocation, configLocation1);
		
		// 4. 1개 이상의 설정 파일 경로를 값으로 전달 가능 : 가변 인자 형태임  
		// 소스가 2개이상이면 컴마로 구분하여 기술하면 된다.
//		AbstractApplicationContext context = 
//				new GenericXmlApplicationContext(
//						"classpath:beans.xml",
//						"classpath:config/beans2.xml");
		// 배열 형태로 사용해도 된다.
		// beans를 나누어 사용 할수 있다.
		String[] conf = { "classpath:beans.xml", "classpath:config/beans2.xml" };
		ApplicationContext context = new GenericXmlApplicationContext(conf);
		
		// B.Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");  
		hello.print();
		
		// 3.PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		hello.setPrinter(printer);  
		hello.print();
		
//		context.close();
	}
}
