package com.study.spring;

public class Hello
{
	// DTO객체 생성시 정보은닉을 위해 private으로 선언한다. 
	private String name;  
	private String nickname;  
	private Printer printer;
	
	// 기본 생성자
	public Hello() {}
	
	// 생성자
	public Hello(String name, String nickname, Printer printer)
	{
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	// 멤버변수 출력용 메서드
	public String sayHello() {
		return "Hello " + name + " : " + nickname;
	}
	public void print() {  
		printer.print(sayHello());
	}
}
