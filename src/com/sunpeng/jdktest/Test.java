package com.sunpeng.jdktest;
import  static java.lang.Math.sqrt;

import  static java.time.ZonedDateTime.now;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Test {
	
	public static void main(String[] args) {

		 MathOperation addition = (int a, int b) -> a + b;
		 
		 List<Student> studentList = new ArrayList<Student>();
		 studentList.add(new Student("张三","男",19,"篮球"));
		 studentList.add(new Student("李四","男",20,"跑步"));
		 studentList.add(new Student("王五","女",21,"篮球"));
		 studentList.add(new Student("王五1","女",12,"篮球"));
		 
		long count =  studentList.stream().filter(s -> "男".equals(s.getSex())).count();
	
		studentList.stream().forEach(s-> s.setAge(s.getAge() + 1));
		System.out.println(count); 
		
		System.out.println(studentList.get(0).getAge());
		List<Student> sortedList = studentList.stream().sorted((s1,s2) -> s1.getAge() - s2.getAge()).collect(Collectors.toList());
		System.out.println(sortedList.get(0).getAge());
		
		ZonedDateTime currentTime  = now();
		System.out.println(currentTime);
		
		 
	}
	
	  interface MathOperation {
	      int operation(int a, int b);
	   }
}


class Student{
	private String name ;
	private String sex;
	private int age;
	private String hobby;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Student(String name, String sex, int age, String hobby) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.hobby = hobby;
	}
	
	
	
}