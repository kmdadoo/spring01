package com.study.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class OtherStudent
{
	private String name;
	private int age;
	
	public OtherStudent(String name, int age)
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
	
	// 어노테이션 사용을 권장
	// 의존 관계 주입(DI)가 이루어진 후 초기화를 수행하여 객체의 값을 설정한 채로 호출할 수 있다
	@PostConstruct
	public void initMethod() {
		System.out.println("OtherStudent : initMethod()");
	}
	
	@PreDestroy // ApplicationContext 에서 Bean을 제거하기 위해 사용됩니다.
	public void destroyMethod() {
		System.out.println("OtherStudent : destroyMethod()");
	}
}
