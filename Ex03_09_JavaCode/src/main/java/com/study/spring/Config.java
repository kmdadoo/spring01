package com.study.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
	@Configuration : 해당 클래스를 스프링 설정파일로 사용하겠다는 선언으로
	XML설정 파일을 사용하는 대신 JAVA파일을 설정파일로 사용한다.
	
	코드안에 있어 수시로 사용할 수 있는 장점이 있으나 좋지는 않음.
*/
@Configuration
public class Config
{
	/*
	 	@Bean : <bean> 엘리먼트와 같이 자바빈을 생성할 때 선언한다.
	 		생성된 빈은 컨트롤러에서 getBean()메서드를 통해 주입받을 수 
	 		있다. 메서드명은 주입받을때의 참조변수명으로 사용한다.
	 		즉 Hello hellobean = new Hello()와 동일하다.
	 */
	@Bean
	public Hello hello() {	// 빈이 만들어짐. 프로퍼티로 만듬
		Hello hello1 = new Hello();
		hello1.setName("홍길동");
		hello1.setNickname("전우치");
		hello1.setPrinter(new PrinterA());
		
		return hello1;
	}
	
	@Bean(name="hello1")	// 다른 이름으로 만들고 싶으면 이렇게 설정할 것. 빈이름은 hello1임
	public Hello hello2() {
		return new Hello("홍길동1", "전우치1", new PrinterA());	// 생성자로 만듬
	}
	
	@Bean
	public PrinterA printerA() {
		return new PrinterA();
	}
	
	@Bean
	public PrinterB printerB() {
		return new PrinterB();
	}
}
