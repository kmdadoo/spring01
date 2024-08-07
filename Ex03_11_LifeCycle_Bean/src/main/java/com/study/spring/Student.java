package com.study.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean
{
	private String name;
	private int age;
	
	public Student(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	@Override
	/*
		 InintializingBean 인터페이스의 메소드로 BeanFactory에 의해 모든 property 가 
		 설정되고 난 뒤 실행되는 메소드입니다. 주로 실행시점의 custom 초기화 로직이 
		 필요하거나 주입받은 property 를 확인하는 용도로 사용
	*/
	public void afterPropertiesSet() throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("Student : afterPropertiesSet()");
	}
	
	@Override
	// 연결작업 종료
	public void destroy() throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("Student : destroy()");
	}
}
